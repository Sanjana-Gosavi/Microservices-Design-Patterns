package com.prowings.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Value("${server.port}")
	String port;
	
	@GetMapping("/orders")
	public String getOrders() {
		return "List Of orders : running on Port: "+port;
	}
}
