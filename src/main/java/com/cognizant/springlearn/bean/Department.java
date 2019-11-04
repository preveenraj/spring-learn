package com.cognizant.springlearn.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dp_id")
	private int id;
	@Column(name="dp_name")
	private String name;
	
//	 @JsonIgnore
//	   @JsonBackReference
	 @OneToMany(mappedBy = "department")
	private Set<Employee> employeeList;
	
	
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


	public Set<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}



/*
public class Department {
	
	@NotNull
	@Min(value=0)
	@Digits(fraction = 0, integer = 5)
	private int id;
	@NotNull
	@NotBlank(message="Name should not be blank")
	@Size(min=1, max=30, message="Name should be between 1 and 30 characters")
	private String name;
	
	public Department() {
		super();
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
*/