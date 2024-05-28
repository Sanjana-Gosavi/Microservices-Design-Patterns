package com.prowings.climateapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prowings.climateapi.entity.Climate;

@Repository
public interface ClimateRepository extends JpaRepository<Climate, Integer>{

	public Climate findByCity(String city);
}
