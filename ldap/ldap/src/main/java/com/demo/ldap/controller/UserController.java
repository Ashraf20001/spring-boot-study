package com.demo.ldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ldap.dto.UserDto;
import com.demo.ldap.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
		@Autowired
		private UserService userService;

		@PostMapping("/saveOrUpdate-user")
		public void saveUser(@RequestBody UserDto user) throws Exception {
			userService.saveUserDetails(user);
		}
}
