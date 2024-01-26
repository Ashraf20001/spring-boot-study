package com.problems.java;

import java.util.Scanner;

public class LeastCommonMultiple {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int num1 = userInput.nextInt();
		Scanner userInput2 = new Scanner(System.in);
		int num2 = userInput2.nextInt();
		int res=findLCMOfTwoNumbers(num1,num2);
		System.out.println(res);
	}

	private static int findLCMOfTwoNumbers(int num1, int num2) {
		return num1*num2 / GreatestCommonDivisor.findGCDOfTwoNumbers(num1, num2);
	}
}
