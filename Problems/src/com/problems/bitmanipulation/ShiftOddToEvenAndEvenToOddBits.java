package com.problems.bitmanipulation;

public class ShiftOddToEvenAndEvenToOddBits {
			public static void main(String[] args) {
				int number = 181;
				DecimalToBinary.convertDecimalToBinary(number);
				int switchOddToEvenResult = switchOddToEven(number);
				int switchEvenToOddResult = switchEvenToOdd(number);
				DecimalToBinary.convertDecimalToBinary(switchOddToEvenResult | switchEvenToOddResult);
				
			}

			private static int switchEvenToOdd(int number) {
				int oddHexa=0xAAAAAAAA;
				return (number & oddHexa) >>> 1;
			}

			private static int switchOddToEven(int number) {
				int evenHexa=0x55555555;
				return (number & evenHexa)<<1;
			}
}
