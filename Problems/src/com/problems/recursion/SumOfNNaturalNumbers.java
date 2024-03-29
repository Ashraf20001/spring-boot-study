package com.problems.recursion;

public class SumOfNNaturalNumbers {
		public static void main(String[] args) {
			System.out.println(findSumOfNNaturalNumbers(10));
//			printNNaturalNumbers(5);
		}

		private static void printNNaturalNumbers(int i) {
			if(i==0) {
				return;
			}
			
			printNNaturalNumbers(i-1);
			System.out.println(i);
		}

		private static int findSumOfNNaturalNumbers(int i) {
			if(i==1) {
				return 1;
			}	
			int res=i+findSumOfNNaturalNumbers(i-1);
			return res;
		}
}
