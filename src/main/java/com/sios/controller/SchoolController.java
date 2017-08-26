package com.sios.controller;

import java.util.List;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sios.common.Constants;
import com.sios.common.Status;
import com.sios.common.URLConstants;
import com.sios.services.SchoolService;
import com.sios.vo.ContactUsVo;
import com.sios.vo.SchoolVo;

@Controller
@RequestMapping("/schools")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@RequestMapping(method = RequestMethod.POST, value = URLConstants.ADD_SCHOOLS, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status isSchoolAdded(@RequestHeader("Authentication") String apiKey,
			@RequestBody SchoolVo schoolVo) {
		Status status = new Status();
		try {
			boolean flg = schoolService.isSchoolAdded(schoolVo);
			status.setResponseBody("");
			status.setResponseCode(Constants.POST);
			status.setResponseMessage("Done");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return status;
	}

	@RequestMapping(method = RequestMethod.GET, value = URLConstants.GET_SCHOOLS, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getAllSchools(@RequestHeader("Authentication") String apiKey) {
		Status status = new Status();
		try {
			List<SchoolVo> schoolVoList = schoolService.getAllSchools();
			if (schoolVoList != null && schoolVoList.size() > 0) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(schoolVoList);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("School Records Fetched Successfully");
			} else {
				status.setRequestMethod(Constants.GET);
				status.setResponseBody("");
				status.setResponseCode(Constants.NO_RECORDS);
				status.setResponseMessage("Record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			status.setRequestMethod(Constants.GET);
			status.setResponseBody("");
			status.setResponseCode(Constants.INTERNAL_ERROR);
			status.setResponseMessage(e.getMessage());
		}
		return status;
	}

	@RequestMapping(method = RequestMethod.GET, value = URLConstants.GET_SCHOOL_BY_SCHOOLCODE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getSchoolBySchoolCode(
			@RequestHeader("Authentication") String apiKey,
			@RequestParam String schoolCode) {
		Status status = new Status();
		try {
			SchoolVo schoolVo = schoolService.getSchoolBySchoolCode(schoolCode);
			if (null != schoolVo) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(schoolVo);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("School  Fetched Successfully!");
			} else {
				status.setRequestMethod((byte) 1);
				status.setResponseBody("");
				status.setResponseCode(Constants.NO_RECORDS);
				status.setResponseMessage("Records Not Found for this request");
			}
		} catch (Exception e) {
			e.printStackTrace();
			status.setRequestMethod((byte) 1);
			status.setResponseBody("");
			status.setResponseCode(Constants.INTERNAL_ERROR);
			status.setResponseMessage(e.getMessage());
		}
		return status;

	}
}
