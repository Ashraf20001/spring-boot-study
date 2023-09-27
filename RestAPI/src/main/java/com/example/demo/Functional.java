package com.example.demo;

import java.util.function.Function;

public class Functional {

	public static void main(String[] args) {
		Integer arr = 12;
		String str = "Wed";
		printElements(arr);
		printElements(str);
	}

	public static <E> void printElements(E elements) {
			System.out.println(elements);
		
	}
}
