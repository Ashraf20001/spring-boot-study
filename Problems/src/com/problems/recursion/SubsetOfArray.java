package com.problems.recursion;

public class SubsetOfArray {
		
		public static void main(String[] args) {
			int[] arr=	new int[] {10,20,15,5};
			int sum=40;
			
			System.out.println(getPossibleSubsets(arr, sum,0));
		}
		
		static int getPossibleSubsets(int[] arr, int sum, int i) {
			if(sum==0) {
				return 1;
			}
			else if(sum<0) {
				return 0;
			}
			else if(i==arr.length) {
				return 0;
			}
			
			int res1= getPossibleSubsets(arr, sum-arr[i], i+1);  // pick an element and contribute it for sum
			int res2= getPossibleSubsets(arr, sum, i+1);         // not pick an element and no contribution for sum
																 // incrementation is same for both cases			
			return res1+res2;
		}
}
