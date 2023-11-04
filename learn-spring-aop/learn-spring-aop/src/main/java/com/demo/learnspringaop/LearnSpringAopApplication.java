package com.demo.learnspringaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.learnspringaop.business.BusinessLayer1;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LearnSpringAopApplication.class);
	
	private BusinessLayer1 businessLayer1;

	public LearnSpringAopApplication(BusinessLayer1 businessLayer1) {
		this.businessLayer1 = businessLayer1;
	}


	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Value obtained is {}",businessLayer1.calcMax());
	}

}
