package com.sios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sios.dao.SchoolDao;
import com.sios.helper.ModelVoHelper;
import com.sios.model.School;
import com.sios.vo.SchoolVo;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	@Override
	public boolean isSchoolAdded(SchoolVo schoolVo) throws Exception {
		School school = new School();
		school.setSchoolCode(schoolVo.getSchoolCode());
		school.setSchoolName(schoolVo.getSchoolName());
		school.setPassword(schoolVo.getPassword());
		return schoolDao.isSchoolAdded(school);
	}

	@Override
	public List<SchoolVo> getAllSchools() throws Exception {
		List<School> schoolList = schoolDao.getAllSchools();
		List<SchoolVo> schoolVosList = null;
		if (schoolList != null && schoolList.size() > 0) {
			schoolVosList = new ArrayList<SchoolVo>(schoolList.size());
			for (School school : schoolList) {
				SchoolVo schoolVo = ModelVoHelper.schoolModelToVo(school);
				schoolVosList.add(schoolVo);
			}
		}
		return schoolVosList;
	}

	@Override
	public SchoolVo getSchoolBySchoolCode(String schoolCode) throws Exception {

		School school = schoolDao.getSchoolBySchoolCode(schoolCode);
		SchoolVo schoolVo = null;
		if (school != null) {
			schoolVo = ModelVoHelper.schoolModelToVo(school);
		}
		return schoolVo;
	}

}
