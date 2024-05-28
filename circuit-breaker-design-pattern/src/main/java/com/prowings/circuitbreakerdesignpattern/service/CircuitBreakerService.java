package com.prowings.circuitbreakerdesignpattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.circuitbreakerdesignpattern.model.Climate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class CircuitBreakerService {

	@Autowired
	RestTemplate restTemplate;

	String url = "https://localhost:8084/prowings/climates";
	
	@CircuitBreaker(name = "climateCircuitBreaker", fallbackMethod = "climateFallback")
//	@Retry(name = "climateRetry", fallbackMethod = "climateFallback")
//	@RateLimiter(name = "climateRateLimiter", fallbackMethod = "climateFallback")
	public String getClimate(String city) {
		System.out.println("Service method started!!!");
		Climate response = restTemplate.getForObject(url+city, Climate.class);
		return "Details successfully fetched for city:" +city;
	}
	
	public String climateFallback(Throwable t, String city) {
		System.out.println("in fallback method of climate!!");
		return "Climate service is temporarily unavailable!!";
	}
}
