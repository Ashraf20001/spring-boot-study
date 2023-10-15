package com.oauth.demo.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	@GetMapping("/say-hello")
	public String getHelloWorld() {
		return "Hello-World";
	}

}
