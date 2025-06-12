package com.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int eid;
	String name;
	String department;
	String role;
	String email;
	long contactno;
	String address;
	double salary;
	LocalDate joiningdate;
	LocalDate dob;
	String gender;
	String img;
	
	public Employee() {
		super();
	}

	public Employee(int eid, String name, String department, String role, String email, long contactno, String address,
			double salary, LocalDate joiningdate, LocalDate dob, String gender, String img) {
		super();
		this.eid = eid;
		this.name = name;
		this.department = department;
		this.role = role;
		this.email = email;
		this.contactno = contactno;
		this.address = address;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.dob = dob;
		this.gender = gender;
		this.img = img;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(LocalDate joiningdate) {
		this.joiningdate = joiningdate;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	
	

}
