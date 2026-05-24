package com.problems.java;

import java.util.Scanner;

public class TrailingZeroes {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int userInputInteger = userInput.nextInt();
		int findTrailingZeros = findTrailingZeros(userInputInteger);
		System.out.println(findTrailingZeros);

	}

	private static int findTrailingZeros(int userInputInteger) {
		int powerOf5=5;
		int res=0;
		
		while(userInputInteger>=powerOf5) {
			int ans=userInputInteger/powerOf5;
			res+=ans;
			powerOf5=5 * powerOf5;
		}
		return res;
	}

    /**
     * Time complexity:
     * N is the input integer
     * (5)1 = 0 iteration
     * (5)1(2) = 1 iteration = (5)2
     * (5)2(1) = 2 iterations = (5)3
     * (5)2(2) = 3 iterations = 5(4)
     *
     * (5)2k <= N
     * 2^k <= log5N
     * k <= log2(log5N) O(loglogN)
      */


}
