package com.cognizant.springlearn.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
