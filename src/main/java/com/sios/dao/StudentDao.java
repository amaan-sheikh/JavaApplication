package com.sios.dao;

import java.util.List;

import com.sios.model.Student;

public interface StudentDao {
	
	boolean isStudentAdded(Student student) throws Exception;
	List<Student> getAllStudents() throws Exception;
	Student getStudentByRollNumber(String rollNumber)throws Exception;
	boolean isUpdatedStudent(Student student , String rollNumber)throws Exception;
	boolean  isdeletedStudent(Student student)throws Exception;
}