package com.cognizant.springlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.bean.Employee;
import com.cognizant.springlearn.repository.EmployeeRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
    public Employee get(int id) {
        LOGGER.info("Start");
        return employeeRepository.findById(id).get();
    }
	
	   @Transactional
	    public void save(Employee employee) {
	        LOGGER.info("Start");
	        employeeRepository.save(employee);
	        LOGGER.info("End");
	    }
	   
	   
	   public List<Employee> getAllPermanentEmployees(){
		   
		   return employeeRepository.getAllPermanentEmployees();
		   
	   }
	   
	   public double getAverageSalary(int id){
		   
		   return employeeRepository.getAverageSalary(1);
	   }
	   
	   public List<Employee> getAllEmployeesNative(){
		   
		   return employeeRepository.getAllEmployeesNative();
		   
	   }
	   
	   @Transactional
		 public boolean updateEmployees(Employee employee)  {
			 
		   Employee emp = employeeRepository.findById(employee.getId()).get();
		   if(emp!=null)
			{employeeRepository.save(employee);
		   return true;
			}else
			   return false;
		 }

	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		employeeRepository.save(employee);
		
	}
		 
}
