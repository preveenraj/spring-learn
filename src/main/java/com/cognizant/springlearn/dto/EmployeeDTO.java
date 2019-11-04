package com.cognizant.springlearn.dto;

import java.util.Date;
import java.util.Set;

public class EmployeeDTO {
	
	private int id;
	private String name;
	private double salary;
	private boolean permanent;
	private Date dateOfBirth;
	
	 private DepartmentDTO departmentDTO;
	 
	 
	    public EmployeeDTO() {
		super();
	}


		private Set<SkillDTO> skillList;


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


		public DepartmentDTO getDepartmentDTO() {
			return departmentDTO;
		}


		public void setDepartmentDTO(DepartmentDTO departmentDTO) {
			this.departmentDTO = departmentDTO;
		}


		public Set<SkillDTO> getSkillList() {
			return skillList;
		}


		public void setSkillList(Set<SkillDTO> skillList) {
			this.skillList = skillList;
		}
	    
}

