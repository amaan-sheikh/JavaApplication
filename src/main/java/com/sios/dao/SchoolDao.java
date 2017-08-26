package com.sios.dao;

import java.util.List;

import com.sios.model.School;

public interface SchoolDao {
	
	boolean isSchoolAdded(School school)throws Exception;
	List<School> getAllSchools()throws Exception;
	School getSchoolBySchoolCode(String schoolCode)throws Exception;

}
