package com.problems.bitmanipulation;

public class NumberOfSetBits {

		public static void main(String[] args) {
			int number=125;
			System.out.println(Integer.toBinaryString(number));
			countNumberOfSetBits(number);
		}

		private static void countNumberOfSetBits(int number) {
			int countBits=0;
			while(number>0) {
				number=number & number -1;
				System.out.println(Integer.toBinaryString(number));
				countBits++;
			}
			System.out.println(countBits);
		}
}
