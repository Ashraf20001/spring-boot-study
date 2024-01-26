package com.rest.webservices.restfulwebservices;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class RestfulWebServicesApplication {

	public static void main(String[] args) {	
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
					.allowedMethods("*")
					.allowedOrigins("http://localhost:3000");
			}
		};
	}
	

}
