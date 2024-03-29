package com.problems.bitmanipulation;

public class TrailingZerosInBinary {
	public static void main(String[] args) {
		int num= 168;
		DecimalToBinary.convertDecimalToBinary(num);
		System.out.println(calculateRighSetBitPosition(num));
	}

	private static int calculateRighSetBitPosition(int num) {
		int result = num ^ (num & num-1) ;
		return (int) (Math.log10(result)/Math.log10(2)) ;
	}
}
