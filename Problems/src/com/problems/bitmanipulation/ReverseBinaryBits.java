package com.problems.bitmanipulation;

public class ReverseBinaryBits {
		public static void main(String[] args) {
			
			int number=255;
			reverseBits(number,8);
		}

		public static int reverseBits(int number,int len) {
				String decimalToBinary = DecimalToBinary.convertDecimalToBinary(number);
//				int f=decimalToBinary.length()-1;
				int f=len-1;
				int l= 0;
				int rev=0;
				
				while(f>l) {
					if((number & 1<<f)!=0) {
						rev= rev | 1<< l;
					}
					if((number & 1<<l) !=0) {
						rev= rev | 1<<f;
					}
					
					f--;
					l++;
				}
				
//				System.out.println(rev+" Reverse numbers binary: "+Integer.toBinaryString(rev));
				return rev;
		}
}
