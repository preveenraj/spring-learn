package com.cognizant.springlearn.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;

public class Skill {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@NotNull
	@Min(value=0)
	private int id;
	@NotNull
	@NotBlank(message="Name should not be blank")
	@Size(min=1, max=30, message="Name should be between 1 and 30 characters")
	private String name;
	public Skill() {
		
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
	@Override
	public String toString() {
		return "Skill [id=" + id + ", skill=" + name + "]";
	}
	
	

}
