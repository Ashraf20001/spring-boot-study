package com.problems.bitmanipulation;

public class CountConsecutiveOnes {
		public static void main(String[] args) {
			
			int number=76;
			System.out.println(Integer.toBinaryString(number));
			countLongestConsecutiveOnes(number);
		}

		private static void countLongestConsecutiveOnes(int number) {
			int count=0;
			
			while(number!=0) {
				number=number & (number<<1);
				count++;
			}
			
			
			System.out.println(count);
		}
}
