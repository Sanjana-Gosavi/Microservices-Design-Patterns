package com.prowings.climateapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prowings.climateapi.entity.Climate;
import com.prowings.climateapi.repository.ClimateRepository;

@Service
public class ClimateServiceImpl implements ClimateService{

	@Autowired
	ClimateRepository climateRepository;
	
	@Override
	public Climate createClimate(Climate climate) {
		return climateRepository.save(climate);
	}

	@Override
	public Climate getClimate(String city) {
		return climateRepository.findByCity(city);
	}

}
