package com.prowings.circuitbreakerdesignpattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.circuitbreakerdesignpattern.service.CircuitBreakerService;

@RestController
public class CircuitBreakerController {
	
	private final CircuitBreakerService breakerService;

	@Autowired
	public CircuitBreakerController(CircuitBreakerService breakerService) {
		super();
		this.breakerService = breakerService;
	}

	@GetMapping("/climates/{city}")
	public ResponseEntity<String> getClimate(@PathVariable String city){
		
		System.out.println("Request received to get city from climate api!!");
		String response = breakerService.getClimate(city);
		System.out.println("Request Completed successfully!!!");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@GetMapping("/test-rate-limiter/{city}")
	public ResponseEntity<String> getClimateByCity(@PathVariable String city){
		System.out.println("request to get city from climate api!!");
		String response = breakerService.getClimate(city);
		System.out.println("Request completed successfully!!!");
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
//	@GetMapping("/climate/{city}")
//	public String getClimate(String city) {
//		return breakerService.getClimate(city);
//	}

}
