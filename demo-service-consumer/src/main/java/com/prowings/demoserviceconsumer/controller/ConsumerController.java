package com.prowings.demoserviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.demoserviceconsumer.service.ServiceProviderClient;

@RestController
public class ConsumerController {

	@Autowired
	private ServiceProviderClient serviceProvider;
	
	@GetMapping("/consume")
	public String consumeHello() {
		return serviceProvider.getHello();
	}
}
