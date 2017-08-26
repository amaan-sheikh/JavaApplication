package com.sios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private String rollNumber;
	@Column
	private String serialNumber;
	@Column
	private String className;
	@Column
	private String studentName;
	@Column
	private String studentFatherName;
	@Column
	private String studentMotherName;

	/*
	 * @OneToMany private List<Address> addressList;
	 * 
	 * 
	 * public List<Address> getAddressList() { return addressList; }
	 * 
	 * public void setAddressList(List<Address> addressList) { this.addressList
	 * = addressList; }
	 */
	public Student() {

	}

	public Student(String rollNumber, String serialNumber, String className,
			String studentName, String studentFatherName,
			String studentMotherName) {
		super();
		this.rollNumber = rollNumber;
		this.serialNumber = serialNumber;
		this.className = className;
		this.studentName = studentName;
		this.studentFatherName = studentFatherName;
		this.studentMotherName = studentMotherName;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentFatherName() {
		return studentFatherName;
	}

	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}

	public String getStudentMotherName() {
		return studentMotherName;
	}

	public void setStudentMotherName(String studentMotherName) {
		this.studentMotherName = studentMotherName;
	}

}
