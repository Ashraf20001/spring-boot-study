package com.learn.security.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityController {
		
	@GetMapping("/csrf-token")
	public CsrfToken getCSRFtoken(HttpServletRequest httpServletRequest) {
		return (CsrfToken)httpServletRequest.getAttribute("_csrf");
	}
}
