package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// tells hibernate that Employee is a database managed entity
// POJO
@Entity
// best practice use @Table
@Table(name="emp") // optional only, use it in case the table name is different than classname
public class Employee {

	// for primary key
	@Id
	@Column(name="id")
	private int empid;
	// use @Column either to provide other constraints for the column or if column name is different than the property name
	@Column(name="empname", length = 100, nullable = false)
	private String ename;
	private String city;
	private String phone;
	private String countryCode;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empid, String ename, String city, String phone) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.city = city;
		this.phone = phone;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", city=" + city + ", phone=" + phone + "]";
	}
	
}
