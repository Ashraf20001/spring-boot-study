package com.problems.recursion;

public class SumOfDigits {
		public static void main(String[] args) {
			int n=384;
			System.out.println(sumOfDigits(n));
		}

		private static int sumOfDigits(int n) {
			
			if(n<10) {
				return n;
			}
			int res= sumOfDigits(n/10) + n%10;
			return res;
		}
}
