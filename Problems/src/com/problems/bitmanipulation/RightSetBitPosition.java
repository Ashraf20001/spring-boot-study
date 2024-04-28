package com.problems.bitmanipulation;

public class RightSetBitPosition {
		public static void main(String[] args) {
			int num=120;
			System.out.println(Integer.toBinaryString(num));
//			int position=calculateRightSetBitPosition(num);	// Approach 1
			int position = calculateRightSetBitPositionWithEfficientApproach(num); // Approach 2
			System.out.println(position);
		}

		private static int calculateRightSetBitPositionWithEfficientApproach(int num) {
			int	mask= num & num-1;
			System.out.println(Integer.toBinaryString(mask));
			int result= num ^ mask;
			return (int) (Math.log10(result)/Math.log10(2)) +1; //( zero index position = log2(decimal result of xor)/log2(2) )
		}

		private static int calculateRightSetBitPosition(int num) {

			int position = 1;
			int mask = 1;
			
			if(num==0) {
				return -1;
			}
			
			while ((num & mask) == 0) {
				mask = mask << 1;
				position++;
			}
			return position;
		}
}
