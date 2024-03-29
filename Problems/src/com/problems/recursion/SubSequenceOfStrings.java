package com.problems.recursion;

public class SubSequenceOfStrings {
			public static void main(String[] args) {
				String s="abc";
				genss(s,"");
			}

			private static void genss(String s, String ans) {
				if(s.length()==0) {
					System.out.println(ans);  
					return;
				}
				genss(s.substring(1),ans+s.charAt(0));  // pick first character
				genss(s.substring(1),ans);              // not pick first character
			}
}
