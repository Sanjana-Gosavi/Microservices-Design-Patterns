package com.prowings.climateapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Climate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String city;
	@Column
	private String country;
	@Column
	private String countryCode;
	@Column
	private String date;
	@Column
	private double temperatureInFht;
	@Column
	private String weather;
	@Column
	private String weatherDesc;
	@Column
	private double tempFeelsLike;
	@Column
	private double tempMin;
	@Column
	private double tempMax;
	@Column
	private double pressure;
	@Column
	private double humidity;
	

}
