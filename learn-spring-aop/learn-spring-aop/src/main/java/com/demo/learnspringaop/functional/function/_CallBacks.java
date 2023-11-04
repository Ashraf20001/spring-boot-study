package com.demo.learnspringaop.functional.function;

import java.util.function.Consumer;
import java.util.function.Function;

public class _CallBacks {

	public static void main(String[] args) {
		System.out.println(transformANumberToItsSquare(null,value->value*value ));
		
		printingYourNumber(2,number->System.out.println("Your number is "+number));
	}
	
	static Integer transformANumberToItsSquare(Integer number, Function<Integer, Integer> callback) {
		Integer result = null;
		if (number != null && number > 0) {
			result = callback.apply(number);
		} else {
			result = 0;
		}
		return result;
	}
	
	static void printingYourNumber(Integer number , Consumer<Integer> callback) {
		System.out.println(number + " enters here");
		callback.accept(number);
	}
}
