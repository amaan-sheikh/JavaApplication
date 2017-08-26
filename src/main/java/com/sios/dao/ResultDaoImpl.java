package com.sios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sios.model.Result;

@Component
public class ResultDaoImpl implements ResultDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isResultAdded(Result result) throws Exception {
		boolean flg = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(result);
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
	public List<Result> getAllResults() throws Exception {
		Session session = null;
		List<Result> resultList = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Result");
			resultList = query.list();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return resultList;
	}

	@Override
	public Result getResultByRollNumber(String rollNumber) throws Exception {

		Session session = null;
		Result result = null;
		try {
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from Result where id=:rollNumber");
			query.setParameter("id", rollNumber);
			List<?> list = query.list();
			if (list != null && list.size() > 0) {
				result = (Result) list.get(0);
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}

}
