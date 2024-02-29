package com.demo.ldap.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class UserAction {
	
	@CreatedBy
	@Column(name = "created_by")
	private Integer createdBy;


	@LastModifiedBy
	@Column(name = "modified_by")
	private Integer modifiedBy;


	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;


	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;


	public Integer getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public Integer getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public UserAction(Integer createdBy, Integer modifiedBy, LocalDateTime modifiedDate, LocalDateTime createdDate) {
		super();
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.createdDate = createdDate;
	}


	public UserAction() {
		super();
	}

	
}
