package com.bet.bet1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
/*
@SpringBootApplication includes @Configuration, @EnableAutoConfiguration and @ComponentScan.
Add @EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) to remove whitelabel errors
 */
// to handle whitelabel errors
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Bet1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bet1Application.class, args);
	}

}
