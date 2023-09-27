package com.learn.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@GetMapping(path = "hello-world")
	public String getHelloWorld() {
		return "Hello World";
	}
}
