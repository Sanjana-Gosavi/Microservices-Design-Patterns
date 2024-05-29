package com.prowings.retrydesignpattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.retrydesignpattern.service.RetryService;

@RestController
public class RetryController {
	
private RetryService retryService;
	
	@Autowired
	public RetryController(RetryService retryService) {
		super();
		this.retryService = retryService;
	}

	@GetMapping("/climates/{city}")
	public ResponseEntity<String> getClimate(@PathVariable String city){
		System.out.println("Request received to fetch climate data from climate api!!");
		String response = retryService.getClimate(city);
		System.out.println("Request Completed!!!");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	
}
