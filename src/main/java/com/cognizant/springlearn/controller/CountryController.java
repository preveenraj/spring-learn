package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START");
		LOGGER.info(country.toString());
		
		return country;
		
		
		//Note: GlobalExceptionHandler will deal with the validations.
		/* // Create validator factory
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Validation is done against the annotations defined in country bean
        Set<ConstraintViolation<Country>> violations = validator.validate(country);
        List<String> errors = new ArrayList<String>();

        // Accumulate all errors in an ArrayList of type String
        for (ConstraintViolation<Country> violation : violations) {
            errors.add(violation.getMessage());
        }

        // Throw exception so that the user of this web service receives appropriate error message
        if (violations.size() > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
        }
		
		*/
		
		
	
	}
	

}
