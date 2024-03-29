package com.problems.bitmanipulation;

public class NumberOfSetBits {

		public static void main(String[] args) {
			int number=125;
			DecimalToBinary.convertDecimalToBinary(number);
			countNumberOfSetBits(number);
		}

		private static void countNumberOfSetBits(int number) {
			int countBits=0;
			while(number>0) {
				number=number & number -1;
				countBits++;
			}
			System.out.println(countBits);
		}
}
