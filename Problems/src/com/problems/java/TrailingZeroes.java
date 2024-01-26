package com.problems.java;

import java.util.Scanner;

public class TrailingZeroes {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int userInputInteger = userInput.nextInt();
		int findTrailingZeros = findTrailingZeros(userInputInteger);
		System.out.println(findTrailingZeros);

	}

	private static int findTrailingZeros(int userInputInteger) {
		int powerOf5=5;
		int res=0;
		
		while(userInputInteger>=powerOf5) {
			int ans=userInputInteger/powerOf5;
			res+=ans;
			powerOf5*=powerOf5;
		}
		return res;
	}

}
