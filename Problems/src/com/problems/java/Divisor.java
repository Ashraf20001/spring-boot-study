package com.problems.java;

import java.util.Scanner;

public class Divisor {

		public static void main(String[] args) {
			Scanner number = new Scanner(System.in);
			int integer = number.nextInt();
			findAllDivisor(integer);
		}

		private static void findAllDivisor(int n) {
			
//			for(int i=1;i<=Math.sqrt(n);i++) {      Approach 1 . It won't print in ascending order
//				if(n%i==0) {
//					System.out.println(i);
//					if(i!=n/i) {
//						System.out.println(n/i);
//					}
//				}
//			}
			
			
			int i=0;                           // Approach 2
			for(i=1;i<=Math.sqrt(n);i++) {
				if(n%i==0) {
					System.out.println(i);
				}
			}
			
			for(;i>=1;i--) {
				if(n%i==0 && i!=n/i) {
					System.out.println(n/i);
				}
			}
		}
}
