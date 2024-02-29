package com.demo.ldap.dto;

import java.util.List;

public class UserDto {
		
	private Long userId;
	private String userName;
	private String emailId;
	private List<String> roles;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(Long userId, String userName, String emailId, List<String> roles, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.roles = roles;
		this.password = password;
	}
	
	public UserDto() {
		super();
	}
	
	
}
