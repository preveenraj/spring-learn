package com.cognizant.springlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.springlearn.bean.User;
import com.cognizant.springlearn.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	

	public User getUserByName(String username){
			return userRepository.findByUsername(username);
	}
}
