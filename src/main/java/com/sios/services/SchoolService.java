package com.sios.services;

import java.util.List;

import com.sios.vo.SchoolVo;

public interface SchoolService {
	
	boolean isSchoolAdded(SchoolVo schoolVo)throws Exception;
	List<SchoolVo> getAllSchools()throws Exception;
	SchoolVo getSchoolBySchoolCode(String schoolCode) throws Exception;
}
