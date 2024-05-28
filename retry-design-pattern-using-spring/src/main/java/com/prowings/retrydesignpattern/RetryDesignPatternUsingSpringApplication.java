package com.prowings.retrydesignpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryDesignPatternUsingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryDesignPatternUsingSpringApplication.class, args);
	}

}
