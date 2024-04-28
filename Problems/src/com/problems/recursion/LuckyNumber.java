package com.problems.recursion;

public class LuckyNumber {
		public static void main(String[] args) {
			int n=13,counter=2;
			System.out.println(isNumberLucky(n, counter));
		}

	static boolean isNumberLucky(int n, int counter) {
		if (n % counter == 0) {
			return false;
		} else if (n < counter) {
			return true;
		}
		return isNumberLucky(n - (n / counter), counter + 1);

		/* Subtracting the largest multiple of number using n-(n/counter)
		 * for further progression
		 */
	}
}
