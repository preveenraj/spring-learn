package com.cognizant.springlearn;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String toString()
	{
		return cityName;
	}

}
