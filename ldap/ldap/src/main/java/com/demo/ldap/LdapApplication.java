package com.demo.ldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;

@SpringBootApplication
public class LdapApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdapApplication.class, args);
	}
}
