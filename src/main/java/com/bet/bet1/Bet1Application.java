package com.bet.bet1;

import com.bet.bet1.services.PersonService;
import org.graalvm.compiler.replacements.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
/*
@SpringBootApplication includes @Configuration, @EnableAutoConfiguration and @ComponentScan.
Add @EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) to remove whitelabel errors
 */
// to handle whitelabel errors
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Bet1Application {
	private static final Logger LOG = LoggerFactory.getLogger(Bet1Application.class);
	public static void main(String[] args) {
		LOG.info("STARTING APP");
		SpringApplication.run(Bet1Application.class, args);
	}

}
