package com.problems.recursion;

import java.util.Arrays;

public class Fibonacci {
	public static void main(String[] args) {
//			for(int i=1; i<=10;i++) {
//				
//				System.out.println(fibonacci(i));
//			}

		int[] arr = new int[6 + 1];
		Arrays.fill(arr, -1);
		System.out.println(fibonacci(6));
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
	}

		private static int fibonacci(int n) {
			
			if(n==1 || n==2) {
				return 1;
			}
			
				
			return fibonacci(n-1)+fibonacci(n-2);
		}

    // Memoization tech
	private static int fibonacci(int n, int[] arr) {

		if (arr[n] != -1) {
			return arr[n];
		}

		if (n == 1 || n == 2) {
			arr[n] = 1;
			return arr[n];
		}

		arr[n] = fibonacci(n - 1, arr) + fibonacci(n - 2, arr);
		return arr[n];
	}
}
