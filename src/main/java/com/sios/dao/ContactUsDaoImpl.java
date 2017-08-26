package com.sios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sios.model.ContactUs;

@Component
public class ContactUsDaoImpl implements ContactUsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isContactAdded(ContactUs contactUs) throws Exception {
		boolean flg = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(contactUs);
			tx.commit();
			flg = true;
		} catch (Exception e) {
			flg = false;
		} finally {
			if (null != session) {
				session.close();
			}
		}
		return flg;
	}

	@Override
	public List<ContactUs> getContacts() throws Exception {
		Session session = null;
		List<ContactUs> contactList = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from ContactUs");
			contactList = query.list();

		} finally {
			if (null != session) {
				session.close();
			}
		}
		return contactList;
	}

	@Override
	public ContactUs getContactById(int id) throws Exception {
		Session session = null;
		ContactUs contactUs = null;
		try {
			session = sessionFactory.openSession();
			/*contactUs = (ContactUs) session
					.createQuery(" from ContactUs where id=:id")
					.setParameter("id", id).list();*/
			
			Query query=session
					.createQuery(" from ContactUs where id=:id");
			query.setParameter("id", id);
			List<?> list=query.list();
			if(null !=list && list.size()>0){
				contactUs=(ContactUs)list.get(0);
			}
			
		} finally {
			if (null != session) {
				session.close();
			}
		}

		return contactUs;
	}

}
