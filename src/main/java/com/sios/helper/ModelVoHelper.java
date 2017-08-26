package com.sios.helper;

import com.sios.model.Address;
import com.sios.model.ContactUs;
import com.sios.model.Result;
import com.sios.model.School;
import com.sios.model.Student;
import com.sios.vo.AddressVo;
import com.sios.vo.ContactUsVo;
import com.sios.vo.ResultVo;
import com.sios.vo.SchoolVo;
import com.sios.vo.StudentVo;

public class ModelVoHelper {

	// contactUsVoToModel
	public static ContactUs contactUsVoToModel(ContactUsVo contactUsVo) {
		ContactUs contactUs = new ContactUs();

		contactUs.setId(contactUsVo.getId());
		contactUs.setMessage(contactUsVo.getMessage());

		//

		return contactUs;
	}

	// contactUsModelToVo
	public static ContactUsVo contactUsModelToVo(ContactUs contactUs) {
		ContactUsVo contactUsVo = new ContactUsVo();

		contactUsVo.setId(contactUs.getId());
		contactUsVo.setMessage(contactUs.getMessage());

		//

		return contactUsVo;
	}

	// studentVoToModel
	public static Student studentVoToModel(StudentVo studentVo) {
		Student student = new Student();
		student.setRollNumber(studentVo.getRollNumber());
		student.setSerialNumber(studentVo.getSerialNumber());
		student.setStudentName(studentVo.getStudentName());
		student.setClassName(studentVo.getClassName());
		student.setStudentFatherName(studentVo.getStudentFatherName());
		student.setStudentMotherName(studentVo.getStudentMotherName());

		return student;
	}

	// studentModelToVo

	public static StudentVo studentModelToVo(Student student) {
		StudentVo studentVo = new StudentVo();
		studentVo.setRollNumber(student.getRollNumber());
		studentVo.setStudentName(student.getStudentName());
		studentVo.setSerialNumber(student.getSerialNumber());
		studentVo.setClassName(student.getClassName());
		studentVo.setStudentFatherName(student.getStudentFatherName());
		studentVo.setStudentMotherName(student.getStudentMotherName());
		return studentVo;
	}

	// addressVoToModel
	public static Address addressVoToModel(AddressVo addressVo) {
		Address address = new Address();
		address.setPincode(addressVo.getPincode());
		address.setStreetName(addressVo.getStreetName());
		address.setCityName(addressVo.getCityName());
		address.setStateName(addressVo.getStateName());
		address.setCountryName(addressVo.getCountryName());
		return address;
	}

	// addressModelToVo.

	public static AddressVo addressModelToVo(Address address) {
		AddressVo addressVo = new AddressVo();
		addressVo.setPincode(address.getPincode());
		addressVo.setStreetName(address.getStreetName());
		addressVo.setCityName(address.getCityName());
		addressVo.setStateName(address.getStateName());
		addressVo.setCountryName(address.getCountryName());
		return addressVo;

	}

	// resultModelToVo
	public static ResultVo resultModelToVo(Result result) {
		ResultVo resultVo = new ResultVo();
		resultVo.setRollNumber(result.getRollNumber());
		resultVo.setStudentName(result.getStudentName());
		resultVo.setClassName(result.getClassName());
		resultVo.setYear(result.getYear());
		return resultVo;
	}

	// resultVoToModel

	public static Result resultVoToModel(ResultVo resultVo) {
		Result result = new Result();
		result.setRollNumber(resultVo.getRollNumber());
		result.setStudentName(resultVo.getStudentName());
		result.setClassName(resultVo.getClassName());
		result.setYear(resultVo.getYear());
		return result;
	}

	// schoolMdelToVo
	public static SchoolVo schoolModelToVo(School school) {
		SchoolVo schoolVo = new SchoolVo();
		schoolVo.setSchoolName(school.getSchoolName());
		schoolVo.setSchoolCode(school.getSchoolCode());
		schoolVo.setPassword(school.getPassword());
		return schoolVo;
	}

	// schoolVoToModel
	public static School schoolVoToModel(SchoolVo schoolVo) {
		School school = new School();
		school.setSchoolName(schoolVo.getSchoolName());
		school.setSchoolCode(schoolVo.getSchoolCode());
		school.setPassword(schoolVo.getPassword());
		return school;
	}
}
