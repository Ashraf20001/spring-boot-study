package com.problems.java;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int num1 = userInput.nextInt();
		Scanner userInput2 = new Scanner(System.in);
		int num2 = userInput2.nextInt();
		int res=findGCDOfTwoNumbers(num1,num2);
		System.out.println(res);
	}

	public static int findGCDOfTwoNumbers(int num1, int num2) {
		while(num1!=0 && num2!=0) {
			if(num1>num2) {     // Replacing Maximum number with modulus of two numbers
				num1=num1%num2;    
			}
			else {
				num2=num2%num1;
			}
		}
		return num1!=0?num1:num2;
	}

}
