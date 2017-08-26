package com.sios.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sios.vo.ResultVo;

@Service
public interface ResultService {

	boolean isResultAddress(ResultVo resultVo) throws Exception;

	List<ResultVo> getAllResults() throws Exception;

	ResultVo getResultByRollNumber(String rollNumber) throws Exception;

}
