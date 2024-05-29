package com.prowings.ratelimiterdesignpattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.ratelimiterdesignpattern.model.Climate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class RateLimiterService {
	
	@Autowired
	RestTemplate restTemplate;
	
	String url = "http://localhost:8084/prowings/climates/";
	
	@RateLimiter(name = "climateRateLimiter" , fallbackMethod = "climateFallback")
	public String getClimate(String city) {
		System.out.println("Service method started!!");
		Climate response = restTemplate.getForObject(url + city, Climate.class);
		return "Successfully fetched the details for city:" +city;
	}
	
	public String climateFallback(Throwable t) {
		System.out.println("Climate's fallback method!!!");
		return "Climate service temporary unavailable!!!";
	}

}
