package com.example.demo.helloworldcontroller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	@GetMapping(path="person", headers = "version=1")
	public PersionV1 getFirstVersionOfPerson() {
		return new PersionV1("alice");
	}

}
