package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		return context.getBean("in",Country.class);
	}

	public List getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List countryList = (ArrayList) context.getBean("countryList", ArrayList.class);
		return countryList;
	}

	public Country getCountryByCode(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
		Country country=null;
		for(int i=0;i<countryList.size();i++){
				if(countryList.get(i).getCode().equalsIgnoreCase(code)){
					country = countryList.get(i);
				}
		}
		
		if(country == null){
			throw new CountryNotFoundException();
		}else{
			return country;
		}
		
	}

}
