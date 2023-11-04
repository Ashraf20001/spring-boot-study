package com.demo.learnspringaop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.demo.learnspringaop.datalayer.DataLayer1;

@Service
public class BusinessLayer1 {

	private DataLayer1 dataLayer1;
	
	public BusinessLayer1(DataLayer1 dataLayer1) {
		this.dataLayer1=dataLayer1;
	}
	
	@TimeTrack
	public int calcMax() {
		int[] retrieveData = dataLayer1.retrieveData();
//		throw new RuntimeException("Something Went Wrong..");
		return Arrays.stream(retrieveData).max().orElse(0);
	}
	
	
}
