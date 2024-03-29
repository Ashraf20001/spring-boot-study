package com.problems.bitmanipulation;

public class CountConsecutiveOnes {
		public static void main(String[] args) {
			
			int number=76;
			DecimalToBinary.convertDecimalToBinary(number);
			countLongestConsecutiveOnes(number);
		}

		private static void countLongestConsecutiveOnes(int number) {
			int count=0;
			
			while(number!=0) {
				DecimalToBinary.convertDecimalToBinary(number<<1);
				number=number & (number<<1);
				count++;
			}
			
			
			System.out.println(count);
		}
}
