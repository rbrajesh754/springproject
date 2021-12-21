package com.sp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.Country;
import com.sp.service.CountryService;
import com.sp.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@GetMapping("/country")
	public Country getCountryIndia() {

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in");
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList");
		return list;
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

		Country country = countryService.getCountry(code);
		return country;
	}

	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");
		Country C = countryService.addCountry(country);
		return C;
	}

}
