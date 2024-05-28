package com.prowings.climateapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prowings.climateapi.entity.Climate;
import com.prowings.climateapi.service.ClimateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ClimateController {

	@Autowired
	ClimateService climateService;
	
	@PostMapping("/climates")
	public Climate createClimate(HttpEntity<String> request) throws JsonMappingException, JsonProcessingException {
		String body = request.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Climate climate1 = mapper.readValue(body, Climate.class);
		return climateService.createClimate(climate1);
	}
	
	@GetMapping("/climates/{city}")
	public Climate getClimateByCity(@PathVariable String city) {
		return climateService.getClimate(city);
	}
}
