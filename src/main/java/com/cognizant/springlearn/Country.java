package com.cognizant.springlearn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="country")
public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	@Id
    @NotNull
    @Size(min=2, max=2, message="Country code should be 2 characters")
    @Column(name="co_code")
    private String code;	
    @NotNull
    @Size(min=2, max=50, message="Country name should not exceed 50 characters")
    @Column(name="co_name")
	private String name;
	
	
	public Country() {
		LOGGER.debug("Inside Country Constructor.");
	
	}


	public String getCode() {
		LOGGER.debug("Getting code");
		return code;
	}


	public void setCode(String code) {
		
		LOGGER.debug("Setting code");
		this.code = code;
	}


	public String getName() {
		LOGGER.debug("Getting Name");
		return name;
	}


	public void setName(String name) {
		LOGGER.debug("Setting name");
		this.name = name;
	}


	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	

	
	
}
