package com.sios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sios.dao.StudentDao;
import com.sios.helper.ModelVoHelper;
import com.sios.model.ContactUs;
import com.sios.model.Student;
import com.sios.vo.ContactUsVo;
import com.sios.vo.StudentVo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public boolean isStudentAdded(StudentVo studentVo) throws Exception {
		Student student = new Student();
		student.setRollNumber(studentVo.getRollNumber());
		student.setSerialNumber(studentVo.getSerialNumber());
		student.setStudentName(studentVo.getStudentName());
		student.setClassName(studentVo.getClassName());
		student.setStudentFatherName(studentVo.getStudentFatherName());
		student.setStudentMotherName(studentVo.getStudentMotherName());
		return studentDao.isStudentAdded(student);
	}

	@Override
	public List<StudentVo> getAllStudents() throws Exception {
		
		
		/*List<ContactUs> contactList = contactUsDao.getContacts();
		List<ContactUsVo> contactVoList = null;
		if (null != contactList && contactList.size() > 0) {
			contactVoList = new ArrayList<ContactUsVo>(contactList.size());
			for (ContactUs contactUs : contactList) {
				ContactUsVo contactUsVo = ModelVoHelper
						.contactUsModelToVo(contactUs);
				contactVoList.add(contactUsVo);
			}
		}*/
		//return contactVoList;
		
		List<Student> studentList = studentDao.getAllStudents();
		List<StudentVo> studentVoList = null;
		if (null != studentList && studentList.size() > 0) {
			studentVoList = new ArrayList<StudentVo>(studentList.size());
			for (Student student : studentList) {
				StudentVo studentVo = ModelVoHelper.studentModelToVo(student);
				studentVoList.add(studentVo);
			}
		}
		return studentVoList;
	}

	@Override
	public StudentVo getStudentByRollNumber(String rollNumber) throws Exception {
		Student student = studentDao.getStudentByRollNumber(rollNumber);
		StudentVo studentVo = null;
		if (null != student) {
			studentVo = ModelVoHelper.studentModelToVo(student);
		}
		return studentVo;
	}

}
