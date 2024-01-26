package com.problems.java;

import java.util.Scanner;

public class PrimeNumbers {

		public static void main(String[] args) {
			Scanner userInput = new Scanner(System.in);
			int num1 = userInput.nextInt();

			if(isPrime(num1)) {
				System.out.println("Prime Number");
			}
			else{
				System.out.println("Not A Prime Number");
			}
			
			printAllPrimeNumbers(num1);
		}

		private static void printAllPrimeNumbers(int num1) {
			
			boolean [] booArr	=new boolean[num1+1];			
			
			for(int i=2; i<=num1;i++) {
				if(!booArr[i]) {
					System.out.println(i);
//					for(int j=2*i;j<=num1;j=j+i) {  Approach 1 (j as multiples of i)
//						
//						booArr[j]=true;
//					}
					for(int j=i*i;j<=num1;j=j+i) {    // Approach 2 (j is the square of i)
						
						booArr[j]=true;
					}
				}
			}
			
		}

		private static boolean isPrime(int num1) { 
			
//			for(int i=2; i<=num1/2;i++) {  // Approach 1
//				if(num1%i==0) {
//					return false;
//				}
//			}
//			return true;
			
//			for(int i=2;i*i<=num1;i++) {   // Approach 2
//				if(num1%i==0) {
//					return false;
//				}
//			}
//			return true;
			
			if(num1==1) {                   //Approach 3
				return false;
			}
			if(num1==2 || num1==3) {
				return true;
			}
			if(num1%2==0 || num1%3==0) {
				return false;
			}
			for(int i=5; i<=Math.sqrt(num1);i=i+6) {
				if(num1%i==0) {
					return false;
				}
			}
			return true;
		}
		
		
}
