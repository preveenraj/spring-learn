package com.cognizant.springlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
      @Autowired	
	  private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	  
	  
   public void display()
   {
	   System.out.println(address);
   }
}
