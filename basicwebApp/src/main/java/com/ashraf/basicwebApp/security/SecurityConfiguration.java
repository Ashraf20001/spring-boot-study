package com.ashraf.basicwebApp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager getUserDetails() {

		/**
		 * Depricated way for having username and password in
		 * InMemoryUserDetailsManagaer
		 */
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//		.username("ashraf")
//		.password("Ashraf@123")
//		.roles("ADMIN")
//		.build();
//		return new InMemoryUserDetailsManager(userDetails);

		/**
		 * Bcrypt Password Encoder in InMemoryUserDetailsManager
		 */

		UserDetails userDetails1 = userDetails("ashraf", "Ashraf@123");
		UserDetails userDetails2 = userDetails("saif", "Saif@123");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails userDetails(String username, String password) {
		Function<String, String> passwordEncode = input -> getCustomPasswordEncoder().encode(input);
		UserDetails userDetails = User.builder()
								.passwordEncoder(passwordEncode)
								.username(username)
								.password(password)
								.roles("ADMIN")
								.build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder getCustomPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain configSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated());  // configuring security filter chain to accept and authorize any request
		http.formLogin(withDefaults());                    // re defining the security filter chain to show form when unauthorized request has come
		
		http.csrf().disable();    						   // Cross Site Reference Forgery configuration is disabled to allow h2 website
		http.headers().frameOptions().disable();		   // h2 websites have x frames which are protected by spring security. So by disabling the frames, we can see h2 websites.
		
		return http.build();
	}
}
