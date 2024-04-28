package com.problems.recursion;

public class JosephusProblem {
			public static void main(String[] args) {
				int n= 8;  // No of people
				int k = 4; // Killing factor
				System.out.println(josephus(n,k));
			}

			private static int josephus(int n, int k) {
				if(n==1) {
					return 0;
				}
				
				return (josephus(n-1, k) + k) % n;  // Formula to identify the surviving person index value

				/**
				 * Formula : (jos(n-1,k)+k) % n
				 */
			}
}
