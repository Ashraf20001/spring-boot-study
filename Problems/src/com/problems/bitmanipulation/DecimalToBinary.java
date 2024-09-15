package com.problems.bitmanipulation;

import java.util.Iterator;
import java.util.Scanner;

public class DecimalToBinary {
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int nextInt = scanner.nextInt();
			String decimalToBinary = convertDecimalToBinary(nextInt);
			System.out.println(convertDecimalToBinaryUsingRecursion(nextInt)+" Recursion");
			convertBinaryToDecimal(decimalToBinary);

		}

		public static void convertBinaryToDecimal(String decimalToBinary) {
			int result=0;
			int powerOf2=1;
			
//			char[] charArray = decimalToBinary.toCharArray();
//			
//			for(int i=0; i<charArray.length;i++) {
//				int charCast= charArray[i]-'0';
//				if(charCast==1) {
//					result+=Math.pow(2,i);
//				}
//			}
		
			for (int i =decimalToBinary.length()-1;i>=0;i--) {
				if(decimalToBinary.charAt(i)=='1') {
					result=result+powerOf2;
				}
				powerOf2*=2;
			}
			System.out.println(result);
		}

		public static String convertDecimalToBinary(int n) {
				int decimal=2;
				String binary=""; 
				if(n==0) {
					binary=0+binary;
				}
				
				while(n>=1) {
					binary=n%decimal+binary;
					n=n/decimal;
				}
				
				System.out.println(binary);
				return binary;
		}

		public static String convertDecimalToBinaryUsingRecursion(int n){
			if(n==0){
				return 0+"";
			}
			return convertDecimalToBinaryUsingRecursion(n/2)+n%2;

		}
}
