package com.prowings.climateapi.service;

import com.prowings.climateapi.entity.Climate;

public interface ClimateService {
	
	public Climate createClimate(Climate climate);
	
	public Climate getClimate(String city);

}
