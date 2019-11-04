package com.cognizant.springlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {


	List<Country> findByNameStartingWith(String input);

	List<Country> findByNameContainingOrderByNameDesc(String input);
	
	

}