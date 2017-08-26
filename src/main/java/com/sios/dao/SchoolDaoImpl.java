package com.sios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sios.model.School;

@Component
public class SchoolDaoImpl implements SchoolDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isSchoolAdded(School school) throws Exception {
		boolean flg = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(school);
			transaction.commit();
			flg = true;
		} catch (Exception e) {
			flg = false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return flg;
	}

	@Override
	public List<School> getAllSchools() throws Exception {

		Session session = null;
		List<School> schoolList = null;

		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from School");
			schoolList = query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return schoolList;
	}

	@Override
	public School getSchoolBySchoolCode(String schoolCode) throws Exception {
		Session session = null;
		School school = null;
		try {
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from School where id = :schoolCode");
			query.setParameter("id", schoolCode);
			List<?> list = query.list();
			if (list != null && list.size() > 0) {
				school = (School) list.get(0);
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return school;
	}

}
