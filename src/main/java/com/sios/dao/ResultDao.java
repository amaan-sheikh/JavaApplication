package com.sios.dao;

import java.util.List;

import com.sios.model.Result;

public interface ResultDao {
	
	boolean isResultAdded(Result result)throws Exception;
	 List<Result> getAllResults()throws Exception;
	Result getResultByRollNumber(String rollNumber)throws Exception;

}
