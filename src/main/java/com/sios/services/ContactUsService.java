package com.sios.services;

import java.util.List;

import com.sios.vo.ContactUsVo;

public interface ContactUsService {

	boolean isContactAdded(ContactUsVo contactUsVo) throws Exception;

	List<ContactUsVo> getContacts() throws Exception;

	ContactUsVo getContactById(int id) throws Exception;
}
