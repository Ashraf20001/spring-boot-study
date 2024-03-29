package com.problems.recursion;

public class ReverseSting {
		public static void main(String[] args) {
			String str="absxg";
//			String revStr=reverseString(str);
			String revStr= reverseString(str,"",str.length()-1);
			System.out.println(revStr);
		}

		private static String reverseString(String str, String reverseString, int i) {
			if(i<0) {
				return reverseString;
			}
			return reverseString(str,reverseString+str.charAt(i),i-1);
		}

//		private static String reverseString(String str) {
//			if(str.length()==1) {
//				return str;
//			}
//			return str.substring(str.length()-1)+reverseString(str.substring(0,str.length()-1));
//		}
}
