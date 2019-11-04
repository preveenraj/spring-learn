package com.cognizant.springlearn.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.springlearn.SpringLearnApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceTest.class);
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	   @Test
	    public void testLoadByUserName() {
	        LOGGER.info("Start");
	        UserDetails user = userDetailsService.loadUserByUsername("user");
	        String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
	        assertEquals(expected, user.getPassword());
	        LOGGER.info("End");
	    }

}
