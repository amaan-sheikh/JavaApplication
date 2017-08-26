package com.sios.dao;

import java.util.List;

import com.sios.model.ContactUs;

public interface ContactUsDao {

	boolean isContactAdded(ContactUs contactUs) throws Exception;

	List<ContactUs> getContacts() throws Exception;

	ContactUs getContactById(int id) throws Exception;
}
