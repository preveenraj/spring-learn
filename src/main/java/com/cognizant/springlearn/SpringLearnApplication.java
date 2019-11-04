package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.bean.Employee;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;	

@SpringBootApplication
public class SpringLearnApplication {

	
	private static String word="hello";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(SpringLearnApplication.class, args);
		
	
	
		
//		 displayDate();
//		 displayCountry();
//		 displayCountries();
		 
//		 displayEmployee();
		
	
		
		
		 
			
	}
	
	
	
	
	@GetMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String postwelcome(){
		return "welcome"+"this is a post message";
	}
	
	@GetMapping("/getEmp")
	public ResponseEntity<?> getEmployee(){
		 HttpHeaders headers = new HttpHeaders();
	        headers.add("Success", "Employee is ready");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		 Employee employee = context.getBean("employee", Employee.class);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		 
//		 return ResponseEntity.accepted().headers(headers).body(employee);
		 
//		 return ResponseEntity.badRequest().headers(headers).body(employee);
		 
		
		 
		
	}
	
	
	
	
	
	
	public static void displayEmployee() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		 Employee employee = context.getBean("employee", Employee.class);
		 LOGGER.debug("Employees: {}",employee.toString());

		
	}

	public static void displayDate(){
		
		LOGGER.info("START");
		
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 
		 try {
			 
			 
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Date is:"+ format.format(date));
		    LOGGER.info("END");
		    
		    
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		
	}
	
	
	public static void displayCountry(){
		
		 LOGGER.info("displayCountry Initiated");
		 ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		 Country country = (Country) context.getBean("country", Country.class);
		 LOGGER.debug("Country : {}", country.toString());

		 Country anotherCountry = context.getBean("country", Country.class);
	}
	
	
	public static void displayCountries(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List countryList = (ArrayList) context.getBean("countryList", ArrayList.class);
		for(Object countryItem: countryList.toArray()){
			LOGGER.debug( countryItem.toString());
		}
		
		
		
	}
 
}
