package com.cognizant.springlearn.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@CrossOrigin("http://localhost:4200")
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	public CountryController() {
		LOGGER.info("Inside CountryController Constructor");
	}

	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public Country getCountryIndia(){
		
		return countryService.getCountry();
		
	}
	
	@GetMapping("/countries")
	public ResponseEntity<List> getAllCountries(){
		return new ResponseEntity<List>(countryService.getAllCountries(),HttpStatus.OK);
	}
	
	@GetMapping("/countries/{code}")
	public ResponseEntity<?> getCountryByCode(@PathVariable("code") String code) throws CountryNotFoundException{
		
		Country country = countryService.getCountryByCode(code);
		
		if(country==null){
			return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
	}
	

}
