package com.sios.controller;

import java.util.List;

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
import com.sios.services.ResultService;
import com.sios.vo.ContactUsVo;
import com.sios.vo.ResultVo;

@Controller
@RequestMapping("/results")
public class ResultController {

	@Autowired
	private ResultService resultService;

	@RequestMapping(method = RequestMethod.POST, value = URLConstants.ADD_RESULTS, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status addResults(@RequestHeader("Authentication") String apiKey,
			@RequestBody ResultVo resultVo) {
		Status status = new Status();
		try {
			boolean flg = resultService.isResultAddress(resultVo);
			status.setResponseBody("");
			status.setResponseCode(Constants.POST);
			status.setResponseMessage("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@RequestMapping(value = URLConstants.GET_RESULTS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getAllResults(@RequestHeader("Authentication") String apiKey) {

		Status status = new Status();
		try {
			List<ResultVo> resultVoList = resultService.getAllResults();
			if (null != resultVoList && resultVoList.size() > 0) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(resultVoList);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("Result List Fetched Successfully!");
			} else {
				status.setRequestMethod(Constants.GET);
				status.setResponseBody("");
				status.setResponseCode(Constants.NO_RECORDS);
				status.setResponseMessage("Records Not Found for this request");
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

	@RequestMapping(value = URLConstants.GET_RESULT_BY_ROLLNUMBER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getResultByRollNumber(
			@RequestHeader("Authentication") String apiKey,
			@RequestParam String rollNumber) {

		Status status = new Status();
		try {
			ResultVo resultVo = resultService.getResultByRollNumber(rollNumber);
			if (null != resultVo) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(resultVo);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("Result is Fetched Successfully!");
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
