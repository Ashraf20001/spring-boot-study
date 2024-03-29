package com.problems.recursion;

public class SumOfAllElementsInArray {
		public static void main(String[] args) {
			System.out.println(sumOfAllElements(new int[] {2,5,7,9},0,0));
		}

		private static int sumOfAllElements(int[] arr, int element,int i) {
			if(i==arr.length) {
				return element;
			}
			return sumOfAllElements(arr,element+arr[i],i+1);
		}
}
