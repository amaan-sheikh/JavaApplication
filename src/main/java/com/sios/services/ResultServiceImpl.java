package com.sios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sios.dao.ResultDao;
import com.sios.helper.ModelVoHelper;
import com.sios.model.Result;
import com.sios.vo.ResultVo;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDao resultDao;

	@Override
	public boolean isResultAddress(ResultVo resultVo) throws Exception {
		Result result = new Result();
		result.setRollNumber(resultVo.getRollNumber());
		result.setStudentName(resultVo.getStudentName());
		result.setClassName(resultVo.getClassName());
		result.setYear(resultVo.getYear());
		return resultDao.isResultAdded(result);
	}

	@Override
	public List<ResultVo> getAllResults() throws Exception {
		List<Result> resultList = resultDao.getAllResults();
		List<ResultVo> resultVoList = null;
		if (resultList != null && resultList.size() > 0) {
			resultVoList = new ArrayList<ResultVo>(resultList.size());
			for (Result result : resultList) {
				ResultVo resultVo = ModelVoHelper.resultModelToVo(result);
				resultVoList.add(resultVo);
			}

		}
		return resultVoList;
	}

	@Override
	public ResultVo getResultByRollNumber(String rollNumber) throws Exception {

		Result result = resultDao.getResultByRollNumber(rollNumber);
		ResultVo resultVo = null;
		if (result != null) {
			resultVo = ModelVoHelper.resultModelToVo(result);
		}
		return resultVo;
	}

}
