package com.problems.bitmanipulation;

public class IsGivenNumberPowerOf2 {

	public static void main(String[] args) {
		int number= 32;
		
		System.out.println(checkNumberIsPowerOf2(number));

	}

	private static boolean checkNumberIsPowerOf2(int number) {
		if(number==0) {
			return false;
		}
		
		return (number & number-1)==0;
	}

}
