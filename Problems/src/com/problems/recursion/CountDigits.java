package com.problems.recursion;

public class CountDigits {
		public static void main(String[] args) {
			System.out.println(countDigits(103));
		}

		private static int countDigits(int i) {
			if(i==0) {
				return 0;
			}

			int res=countDigits(i/10)+1;
			return res;
		}
		
}
