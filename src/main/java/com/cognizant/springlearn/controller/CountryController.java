package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
@CrossOrigin("http://localhost:4200")
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	@Autowired
	private CountryService countryService;
	
	public CountryController() {
		LOGGER.info("Inside CountryController Constructor");
	}


//	@GetMapping("/countries")
//	public ResponseEntity<List> getAllCountries(){
//		return new ResponseEntity<List>(countryService.getAllCountries(),HttpStatus.OK);
//	}
	
	@GetMapping("/countries/{code}")
	public ResponseEntity<?> getCountryByCode(@PathVariable("code") String code) throws CountryNotFoundException{
		
		Country country = countryService.getCountryByCode(code);
		
		if(country==null){
			return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
	}
	
	@GetMapping("/countries")
	public ResponseEntity<List> getAllCountries(@RequestParam(required = false) String key){
		if(key!=null)
		return new ResponseEntity<List>(countryService.getCountryList(key),HttpStatus.OK);
		else
			return new ResponseEntity<List>(countryService.getAllCountries(),HttpStatus.OK);
	}
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");
		LOGGER.info(country.toString());
		countryService.addCountry(country);
		return country;
	
	
	}
	
	@PutMapping("/countries")
	public Country updateCountry(@RequestBody @Valid Country country) throws CountryNotFoundException {
		LOGGER.info("START");
		LOGGER.info(country.toString());
		countryService.updateCountry(country);
		return country;
	
	
	}
	
	
	@DeleteMapping("/countries/{code}")
	public ResponseEntity<?> DeleteCountry(@PathVariable("code") String code) throws CountryNotFoundException{
		
		Country country = countryService.getCountryByCode(code);
		
		
		if(country==null){
			return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);
		}else{
			countryService.deleteCountry(code);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
	}
	
	

/*	
	@RequestMapping(value="/country",method=RequestMethod.GET)
	public Country getCountryIndia(){
		
		return countryService.getCountry();
		
	}
	*/
/*	@GetMapping("/countries/{code}")
	public ResponseEntity<?> getCountryByCode(@PathVariable("code") String code) throws CountryNotFoundException{
		
		Country country = countryService.getCountryByCode(code);
		
		if(country==null){
			return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
	}*/
	
/*	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");
		LOGGER.info(country.toString());
		
		return country;
	
	
	}
	*/

}
