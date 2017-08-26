package com.sios.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School {

	@Id
	private String schoolCode;
	private String schoolName;
	private String password;

	public School() {

	}

	public School(String schoolCode, String schoolName, String password) {
		super();
		this.schoolCode = schoolCode;
		this.schoolName = schoolName;
		this.password = password;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
