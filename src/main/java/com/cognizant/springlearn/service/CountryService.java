package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@Service
public class CountryService {

		@Autowired
		CountryRepository countryRepository;

		@Transactional
		public List<Country> getAllCountries(){
			
		List<Country> countries = new ArrayList<Country>();
		 countryRepository.findAll().forEach(countries::add);
		return countries;		 
				 
		}
		
		 @Transactional
		 public Country getCountryByCode(String countryCode) throws CountryNotFoundException {
			 
			 Optional<Country> result = countryRepository.findById(countryCode);
			 if (!result.isPresent()){
				 throw new CountryNotFoundException();
			 }
			 
			 Country country = result.get();
			 
			return country;
			 
		 }
		 
		 @Transactional
		 public void addCountry(Country country) {
			 
			 countryRepository.save(country);
		 }
		 
		 @Transactional
		 public void updateCountry(Country country) throws CountryNotFoundException {
			 
		
			countryRepository.save(country);
		 }
		 
		 @Transactional
		 public void deleteCountry(String code) {
			 
			 countryRepository.deleteById(code);
		 }
		 
		 
			@Transactional
			public List<Country> getCountryList(String input){
	
			return countryRepository.findByNameContainingOrderByNameDesc(input);
					 
			}
			
			@Transactional
			public List<Country> getCountriesStartingWith(String input){
	
			return countryRepository.findByNameStartingWith(input);
					 
			}
			
		 
		 
		 
		 
		 
		 
		 
		 
}

































/*
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
*/