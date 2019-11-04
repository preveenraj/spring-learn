package com.cognizant.springlearn.controller;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.bean.Employee;
import com.cognizant.springlearn.bean.Skill;
import com.cognizant.springlearn.dto.DepartmentDTO;
import com.cognizant.springlearn.dto.EmployeeDTO;
import com.cognizant.springlearn.dto.SkillDTO;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
//
//	@GetMapping("/employees")
//	public ResponseEntity<List> getAllCountries(){
//	return new ResponseEntity<List>(employeeService.getAllEmployeesNative(),HttpStatus.OK);
//		return new ResponseEntity<List>(employeeService.getAllEmployeesNative(),HttpStatus.OK);
//	}
	
	@GetMapping("/employees")
	public EmployeeDTO[] getAllEmployees(){
		return transformEmployeeToDTO(employeeService.getAllEmployeesNative());
	}
	
	
	@PostMapping("/employees")
	public Employee addEmployees(@RequestBody Employee employee){
		 employeeService.addEmployee(employee);
		 return employee;
	}
	
	@PutMapping("/employees")
	public boolean updateEmployees(@RequestBody Employee employee){
		boolean flag=true; 
		flag = employeeService.updateEmployees(employee);
		 return flag;
	}
	
	
	
	
	
	
	
	
	 private EmployeeDTO[] transformEmployeeToDTO(List<Employee> employee) {
		 
		 EmployeeDTO[] employeeDTO = new EmployeeDTO[employee.size()];
		 int i=0;
		 for(Employee emp: employee){
			 
			 employeeDTO[i] = new EmployeeDTO();
			 employeeDTO[i].setId(emp.getId());
			 employeeDTO[i].setName(emp.getName());
			 employeeDTO[i].setPermanent(emp.isPermanent());
			 employeeDTO[i].setSalary(emp.getSalary());
			 
			 DepartmentDTO departmentDTO = new DepartmentDTO();
			 departmentDTO.setId(emp.getDepartment().getId());
			 departmentDTO.setName(emp.getDepartment().getName());

			 employeeDTO[i].setDepartmentDTO(departmentDTO);		 
			 employeeDTO[i].setSkillList(new HashSet<SkillDTO>());
			 
			 for(Skill skill: emp.getSkillList()){
				 SkillDTO skillDTO = new SkillDTO();
				 skillDTO.setId(skill.getId());
				 skillDTO.setName(skill.getName());
				 employeeDTO[i].getSkillList().add(skillDTO);
			 }
	
			 i++;
		
		 }
		
	
		 
		 
		 
		 return employeeDTO;
	 }
	

}
