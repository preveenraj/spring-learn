package com.cognizant.springlearn.bean;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Employee {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
	
	private int id;
	private String name;
	private double salary;
	private boolean permanent;
	private Date dateOfBirth;
	private Department department;
	private Skill[] skills;
	
	
	public Skill[] getSkills() {
		return skills;
	}


	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Employee() {
		LOGGER.debug("Inside Employee Constructor");
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skills=" + Arrays.toString(skills)
				+ "]";
	}
	

}
