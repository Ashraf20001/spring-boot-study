package com.problems.bitmanipulation;

public class ReverseBinaryBits {
		public static void main(String[] args) {
			
			int number=5;
			System.out.println(Integer.toBinaryString(number));
			int revBits = revBits(number,8);
			System.out.println(Integer.toBinaryString(revBits));
			
		}

				
		
		public static int revBits(int number, int len) {
			int l= len-1; // position of last bit with zero based index
			int f=0;      // position of first bit with zero based index
			int rev=0;
			
			while(f<=l) {
				if((number & 1<<l)!=0) {
					rev=rev | 1<<f; // switching to set at f position in rev number.
				}
				if((number & 1<<f)!=0) {
					rev= rev | 1<<l; // switching to set at l position in rev number.
				}
				l--;                 // moving back;
				f++;                 // moving forward
				
			}
			
			return rev;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
