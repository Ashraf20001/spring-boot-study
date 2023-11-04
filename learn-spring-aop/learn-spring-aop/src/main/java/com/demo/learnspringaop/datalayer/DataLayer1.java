package com.demo.learnspringaop.datalayer;

import org.springframework.stereotype.Repository;

@Repository
public class DataLayer1 {

	public int[] retrieveData() {
		int[] arr = new int[] { 2, 4, 6,100, 9, 1 };
		return arr;

	}
}
