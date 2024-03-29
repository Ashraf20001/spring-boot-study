package com.problems.bitmanipulation;

public class LonelyInteger {
		public static void main(String[] args) {
				int[] arr= new int [] {2,5,6,3,2,3,6};
				
				findLonelyInteger(arr);
		}

		private static void findLonelyInteger(int[] arr) {
			int result=0;
			
			for (int i : arr) {
				result=result ^ i;
			}
			
			System.out.println(result);
		}
}
