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
			
			
			/**
			 * Things to remember here
			 * 1. odd hexa = 0xAAAAAAAA ----> 8 A's
			 * 2. even hexa= 0x55555555 ----> 8 5's
			 * 3. odd -> triple right shift
			 * 4. even-> left shift
			 * 5. merge shifts using or(|)
			 */
}
