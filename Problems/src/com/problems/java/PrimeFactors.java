package com.problems.java;

import java.util.Scanner;

public class PrimeFactors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nextInt = scanner.nextInt();
		if(nextInt!=0) {
			calculatePrimeFactors(nextInt);
		}

	}

	private static void calculatePrimeFactors(int nextInt) {
		
		int i=2;
		while (i * i <= nextInt) {
			while (nextInt % i == 0) {
				nextInt = nextInt / i;
				System.out.println(i);
			}
			i++;
		}
		
		if(nextInt>1) {
			System.out.println(nextInt);
		}
	}

}
