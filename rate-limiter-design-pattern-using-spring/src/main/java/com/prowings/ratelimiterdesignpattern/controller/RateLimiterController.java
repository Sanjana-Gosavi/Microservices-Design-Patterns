package com.prowings.ratelimiterdesignpattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.ratelimiterdesignpattern.service.RateLimiterService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class RateLimiterController {
	
	private RateLimiterService rateLimiterService;

	@Autowired
	public RateLimiterController(RateLimiterService rateLimiterService) {
		super();
		this.rateLimiterService = rateLimiterService;
	}
	
	@GetMapping("/climate/{city}")
	public ResponseEntity<String> getClimate(@PathVariable String city){
		System.out.println("Request received to get climate details from api!");
		String response = rateLimiterService.getClimate(city);
		System.out.println("Request completed!!!");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
