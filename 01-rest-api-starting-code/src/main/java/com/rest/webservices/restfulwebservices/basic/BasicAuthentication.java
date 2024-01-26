package com.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthentication {

		@Bean
		public SecurityFilterChain filterChainConfig(HttpSecurity http)  throws Exception {
			return http.authorizeHttpRequests(
					auth->
					auth.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
				    .anyRequest().authenticated()
					)
					.httpBasic(Customizer.withDefaults())
					.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.csrf().disable()
					.headers(header->{
						header.frameOptions().sameOrigin();
					})
					.build();
		}
}
