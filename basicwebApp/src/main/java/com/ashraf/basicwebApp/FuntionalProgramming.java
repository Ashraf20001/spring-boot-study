package com.ashraf.basicwebApp;

import java.util.List;

public class FuntionalProgramming {

	public static void main(String[] args) {
			
		printAllNumbers(List.of("Ashraf","Farook","Khalid","Hamza","AbuBacker"));
	}

	private static void printAllNumbers(List<String> strings) {
		
		strings.stream()
		.map(string->string.length())
		.forEach(System.out::println);
		
	}

}
