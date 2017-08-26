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
import com.sios.services.ContactUsService;
import com.sios.vo.ContactUsVo;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private ContactUsService contactUsService;

	@RequestMapping(value = URLConstants.ADD_CONTACTS, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status addContacts(@RequestHeader("Authentication") String apiKey,
			@RequestBody ContactUsVo contactUsVo) {

		Status status = new Status();
		try {
			boolean flg = contactUsService.isContactAdded(contactUsVo);

			status.setResponseBody("");
			status.setResponseCode(Constants.POST);
			status.setResponseMessage("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@RequestMapping(value = "/getContacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getContacts(@RequestHeader("Authentication") String apiKey) {

		Status status = new Status();
		try {
			List<ContactUsVo> contactList = contactUsService.getContacts();
			if (null != contactList && contactList.size() > 0) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(contactList);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("Contact List Fetched Successfully!");
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

	@RequestMapping(value = "/getContactById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getContactById(
			@RequestHeader("Authentication") String apiKey, @RequestParam int id) {

		Status status = new Status();
		try {
			ContactUsVo contactUsVo = contactUsService.getContactById(id);
			if (null != contactUsVo) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(contactUsVo);
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
