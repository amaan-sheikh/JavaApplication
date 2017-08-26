package com.sios.services;

import java.util.List;

import com.sios.vo.StudentVo;

public interface StudentService {

	boolean isStudentAdded(StudentVo studentVo) throws Exception;

	List<StudentVo> getAllStudents() throws Exception;

	StudentVo getStudentByRollNumber(String rollNumber) throws Exception;

}
