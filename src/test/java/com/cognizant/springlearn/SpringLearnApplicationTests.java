package com.cognizant.springlearn;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.springlearn.controller.CountryController;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {
	
	 @Autowired
	 private CountryController countryController;
	 
	 @Autowired
	 private MockMvc mvc;
	 
	  @Test
	    public void testGetCountry() throws Exception {
	        ResultActions actions = mvc.perform(get("/country"));
	        actions.andExpect(status().isOk());
	        actions.andExpect(jsonPath("$.code").exists());
	        actions.andExpect(jsonPath("$.code").value("IN"));
	        
	        actions.andExpect(jsonPath("$.name").exists());
	        actions.andExpect(jsonPath("$.name").value("India"));
	    }

	  @Test
	  public void testGetCountryException() throws Exception {
	       ResultActions actions = mvc.perform(get("/country"));
	        actions.andExpect(status().isBadRequest());
	        actions.andExpect(status().reason("Country Not found"));
	  }

	@Test
	public void contextLoads() {
		
        assertNotNull(countryController);
	}

}
