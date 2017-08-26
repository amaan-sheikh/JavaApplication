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
import com.sios.services.AddressService;
import com.sios.vo.AddressVo;

@Controller
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(method = RequestMethod.POST, value = "/addAddress", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status addAddresses(@RequestHeader("Authentication") String apiKey,
			@RequestBody AddressVo addressVo) {
		Status status = new Status();
		try {
			boolean flg = addressService.isAddressAdded(addressVo);
			status.setResponseBody("");
			status.setRequestMethod(Constants.POST);
			status.setResponseMessage("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllAddresses", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getAllAddresses(@RequestHeader("Authentication") String apiKey) {
		Status status = new Status();
		try {
			List<AddressVo> addressVoList = addressService.getAllAddresses();
			if (addressVoList != null && addressVoList.size() > 0) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(addressVoList);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("Addresses List Fetched Successfully!");
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

	@RequestMapping(value = URLConstants.GET_ADDRESS_BY_PINCODE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Status getAddressByPincode(
			@RequestHeader("Authentication") String apiKey,
			@RequestParam int pincode) {

		Status status = new Status();
		try {
			AddressVo addressVo = addressService.getAddressByPincode(pincode);
			if (null != addressVo) {
				status.setRequestMethod((byte) 1);
				status.setResponseBody(addressVo);
				status.setResponseCode(Constants.OK);
				status.setResponseMessage("Addresses  Fetched Successfully!");
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
