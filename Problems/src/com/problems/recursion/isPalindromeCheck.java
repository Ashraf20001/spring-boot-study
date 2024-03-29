package com.problems.recursion;

public class isPalindromeCheck {
		public static void main(String[] args) {
			String str= "abba";
			boolean isPalindrome= checkIsPalindromeOrNot(str,0,str.length()-1);
			System.out.println(isPalindrome);
		}

		private static boolean checkIsPalindromeOrNot(String str, int i, int j) {
			if(str.charAt(i)!=str.charAt(j)) {
				return false;
			}
			if(i>j) {
				return true;
			}
			return checkIsPalindromeOrNot(str, i+1, j-1);
		}
}
