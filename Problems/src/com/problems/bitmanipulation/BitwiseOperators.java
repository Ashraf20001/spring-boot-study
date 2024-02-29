package com.problems.bitmanipulation;

public class BitwiseOperators {

	public static void main(String[] args) {
		int n=36;
		int i=5;
		int maskOfI=1<<i;
		switchOnBit(n,i,maskOfI);
		switchOffBit(n,i,maskOfI);
		toggle(n,i,maskOfI);
		checkOffOrOn(n,i,maskOfI);
	}

	private static void toggle(int n, int i, int maskOfI) {
		System.out.println("Toggle");
		DecimalToBinary.convertDecimalToBinary(n);
		int result=n ^ maskOfI;
		System.out.println(result);
		DecimalToBinary.convertDecimalToBinary(result);
		System.out.println();
		
		
	}

	private static void checkOffOrOn(int n, int i, int maskOfI) {
		System.out.println("Check on or off");
		if((n & maskOfI) == 0) {
			System.out.println("OFF");
		}
		else {
			System.out.println("ON");
		}
	}

	private static void switchOffBit(int n, int i,int maskOfI) {
		System.out.println("Switch off...");
		System.out.println();
		DecimalToBinary.convertDecimalToBinary(n);
		int result=n & ~maskOfI;
		System.out.println(result);
		DecimalToBinary.convertDecimalToBinary(result);
		System.out.println();
	}

	private static void switchOnBit(int n,int i,int maskOfI) {
		System.out.println("Switch on...");
		System.out.println();
		DecimalToBinary.convertDecimalToBinary(n);
		int result=n | maskOfI;
		System.out.println(result);
		DecimalToBinary.convertDecimalToBinary(result);
		System.out.println();
	}

}
