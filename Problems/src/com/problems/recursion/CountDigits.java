package com.problems.recursion;

public class CountDigits {
		public static void main(String[] args) {
			int count=0;
			System.out.println(countDigits(103,count));
		}

		private static int countDigits(int i,int count) {
			if(i==0) {
				return count;
			}

			int res=countDigits(i/10,count+1);
			return res;
		}
}
