package com.problems.recursion;

public class Fibonacci {
		public static void main(String[] args) {
			for(int i=1; i<=10;i++) {
				
				System.out.println(fibonacci(i));
			}
		}

		private static int fibonacci(int n) {
			
			if(n==1 || n==2) {
				return 1;
			}
			
				
			return fibonacci(n-1)+fibonacci(n-2);
		}
}
