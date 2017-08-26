package com.sios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sios.dao.ContactUsDao;
import com.sios.helper.ModelVoHelper;
import com.sios.model.ContactUs;
import com.sios.vo.ContactUsVo;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	private ContactUsDao contactUsDao;

	@Override
	public boolean isContactAdded(ContactUsVo contactUsVo) throws Exception {

		ContactUs contactUs = new ContactUs();

		contactUs.setMessage(contactUsVo.getMessage());
		return contactUsDao.isContactAdded(contactUs);

	}

	@Override
	public List<ContactUsVo> getContacts() throws Exception {

		List<ContactUs> contactList = contactUsDao.getContacts();
		List<ContactUsVo> contactVoList = null;
		if (null != contactList && contactList.size() > 0) {
			contactVoList = new ArrayList<ContactUsVo>(contactList.size());
			for (ContactUs contactUs : contactList) {
				ContactUsVo contactUsVo = ModelVoHelper
						.contactUsModelToVo(contactUs);
				contactVoList.add(contactUsVo);
			}
		}
		return contactVoList;
	}

	@Override
	public ContactUsVo getContactById(int id) throws Exception {
		ContactUs contactUs = contactUsDao.getContactById(id);
		ContactUsVo contactUsVo = null;
		if (null != contactUs) {
			contactUsVo = ModelVoHelper.contactUsModelToVo(contactUs);
		}
		return contactUsVo;
	}

}
