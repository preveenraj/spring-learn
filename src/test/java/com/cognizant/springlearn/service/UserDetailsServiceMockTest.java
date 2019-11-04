package com.cognizant.springlearn.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.springlearn.bean.Role;
import com.cognizant.springlearn.bean.User;
import com.cognizant.springlearn.repository.UserRepository;
import com.cognizant.springlearn.security.AppUserDetailsService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDetailsServiceMockTest {

	
	
	@Test
	public void mockTestLoadUserByUsername() {
		
		
		
		UserRepository repository= Mockito.mock(UserRepository.class);
		when(repository.findByUsername("user")).thenReturn(createUser());
		AppUserDetailsService service = new AppUserDetailsService(repository);
		UserDetails user = service.loadUserByUsername("user");
		String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
		assertEquals(expected, user.getPassword());
	
	}
	
	public User createUser(){
		
		User user = new User();
		user.setId(1);
		user.setUsername("user");
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		user.setRoleList(new ArrayList<Role>());
		return user;
		
		
	}
}
