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
import com.sios.services.StudentService;
import com.sios.vo.StudentVo;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// ADDING
	// STUDENTS================================================================================================
	@RequestMapping(value = URLConstants.ADD_STUDENTS, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status addStudents(@RequestHeader("Authentication") String apiKey,
			@RequestBody StudentVo studentVo) {
		Status status = new Status();
		try {
			boolean flag = studentService.isStudentAdded(studentVo);
			status.setResponseBody("");
			status.setResponseCode(Constants.POST);
			status.setResponseMessage("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// GETTING ALL STUDENTS =======================================================================================

	@RequestMapping(value = URLConstants.GET_STUDENTS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getAllStudents(@RequestHeader("Authentication") String apiKey) {
		Status status = new Status();
		try {
			List<StudentVo> studentList = studentService.getAllStudents();
			if (null != studentList && studentList.size() > 0) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(studentList);
				status.setResponseCode(Constants.NO_RECORDS);
				status.setResponseMessage("Record Fetched Successfully");
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

	// GETTING STUDENTS BY THERE ROLL
	// NUMBERS==================================================================================

	@RequestMapping(value = URLConstants.GET_STUDENT_BY_ROLLNUMBER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getStudentByRollNumber(
			@RequestHeader("Authentication") String apiKey,
			@RequestParam String rollNumber) {

		Status status = new Status();
		try {
			StudentVo studentVo = studentService
					.getStudentByRollNumber(rollNumber);

			if (null != studentVo) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(studentVo);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("Contact List Fetched Successfully!");
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
