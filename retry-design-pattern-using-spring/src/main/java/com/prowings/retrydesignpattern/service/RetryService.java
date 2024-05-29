package com.prowings.retrydesignpattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.retrydesignpattern.model.Climate;

@Service
public class RetryService {

	@Autowired
	RestTemplate restTemplate;
	
	String url = "http://localhost:8084/prowings/climates/";
	
	@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
	public String getClimate(String city) {
		System.out.println("Service method invoked!!");
		Climate response = restTemplate.getForObject(url+city, Climate.class);
		return "Details successfully fetched for city :" +city;
	}
	
	@Recover
	public String climateFallback(Throwable t, String city) {
		System.out.println("In fallback method of climate!!");
		return "Climate service is temporarily unavailable!!";
	}
}
