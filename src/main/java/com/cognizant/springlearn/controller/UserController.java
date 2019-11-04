package com.cognizant.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.security.AppUserDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

/*	
	@Autowired
	private UserService userService;*/
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@GetMapping("/users")
	public Object getUsers(){
		return appUserDetailsService.loadUserByUsername("admin");
//		return "You got the user";
	}
	
	
}
