package com.prowings.retrydesignpattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.retrydesignpattern.model.Climate;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class RetryService {
	
	@Autowired
	RestTemplate restTemplate;
	
	String url = "http://localhost:8084/prowings/climates/";
	
	@Retry(name = "retryClimate", fallbackMethod = "climateFallback")
	public String getClimate(String city) {
		System.out.println("Service method started!!");
		Climate response = restTemplate.getForObject(url+city, Climate.class);
		return "Details Successfully fetched for city:" +city;
	}

	
	public String climateFallback(Throwable t, String city) {
		System.out.println("In fallback method of climate!!");
		return "Climate service is temporarily unavailable!!";
	}
}
