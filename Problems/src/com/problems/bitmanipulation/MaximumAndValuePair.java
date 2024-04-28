package com.problems.bitmanipulation;

public class MaximumAndValuePair {
		
		public static void main(String[] args) {
			int arr[] = {16,9,6,13};
			System.out.println(getMaximumAndValueResult(arr));
		}
		
		public static int checkSetBitsCount(int arr[], int mask) {
			int count=0;
			for(int i=0;i<arr.length;i++) {
				if((mask & arr[i])==mask) {    // check mask and & operation result are equal
					count++;
				}
			}
			return count;
		}
		
		public static int getMaximumAndValueResult(int arr[]) {
			int res=0;
			int mask=0;
			for(int i=31; i>=0 ; i--) {
				mask= 1<< i | res;            // set bit will be left shifted according to  position and merge with result 
				int count= checkSetBitsCount(arr, mask);
				if(count>=2) {
					res= res | mask;      // update the result only if count > =2
				}
			}
			return res;
		}
		
		/**
		 * 1. Masking
		 * 2. Set bit Identification
		 * 3. Count verification
		 * 4. Merge of mask with result based on count
		 */
}
