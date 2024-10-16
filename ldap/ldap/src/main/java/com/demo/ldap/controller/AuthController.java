package com.demo.ldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ldap.dto.LoginDto;
import com.demo.ldap.service.AuthService;

@RestController
public class AuthController {

		@Autowired
		private AuthService authService;
	
		@PostMapping("/auth/user")
		public ResponseEntity<String> authenticateUserDetails(@RequestBody LoginDto loginobj) throws Exception{
				String authenticateUser = authService.authenticateUser(loginobj);
				if(authenticateUser!=null) {
					return ResponseEntity.ok(authenticateUser);
				}
				
				return ResponseEntity.badRequest().build();
		}
		
		
}
