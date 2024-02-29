package com.demo.ldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldAPI {
		@GetMapping("/hello")
		public String getHelloWorld(){
			return "Hello World";
		}
}
