package com.prowings.retrydesignpattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.retrydesignpattern.model.Climate;

@Service
public class RetryService {

	@Autowired
	RestTemplate restTemplate;
	
	String url = "http://localhost:8084/prowings/climates/";
	
	public String getClimate(String city) {
		System.out.println("Service method invoked!!");
		Climate response = restTemplate.getForObject(url+city, Climate.class);
		return "Details successfully fetched for city" +city;
		
	}
}
