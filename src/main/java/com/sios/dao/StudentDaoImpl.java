package com.sios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sios.model.Student;

@Component
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean isStudentAdded(Student student) throws Exception { 
		boolean flg =false;
		Session session = null;
		try
		{
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(student);
			transaction.commit();
			flg = true;
		}catch(Exception e)
		{
			flg = false;
					
		}
		finally
		{
			if(null!=session)
			{
				session.close();
			}
		}
		return flg;
	}

	@Override
	public List<Student> getAllStudents() throws Exception {
		Session session = null;
		List<Student> studentsList =null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Student");
			studentsList=query.list();
			
		}
		finally
		{
			if(null!=session)
			{
				session.close();
			}
		}
		 
		return studentsList;
	}

	@Override
	public Student getStudentByRollNumber(String rollNumber) throws Exception {
		
		Session session = null;
		Student student =null;
		try{
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Student where id=:rollNumber");
			query.setParameter("id", rollNumber);
			List<?> list=query.list();
			if(null!=list && list.size()>0)
			{
				student =(Student)list.get(0);
			}
			
			
		}
		finally
		{
			if(null!=session)
			{
				session.close();
			}
		}
		return student;
	}

	@Override
	public boolean isUpdatedStudent(Student student, String rollNumber)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isdeletedStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	

}

