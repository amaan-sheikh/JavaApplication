package com.sios.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {

	@Id
	private String rollNumber;
	private String studentName;
	private String className;
	private String year;

	public Result() {

	}

	public Result(String rollNumber, String studentName, String className,
			String year) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.className = className;
		this.year = year;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
