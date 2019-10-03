package com.cognizant.springlearn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;

public class Skill {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	
	private int id;
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
