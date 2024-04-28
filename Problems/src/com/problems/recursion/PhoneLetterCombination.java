package com.problems.recursion;

public class PhoneLetterCombination {
	
		static String[] keypad= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
		public static void main(String[] args) {
			String s="576";
			phoneLC(s,"");
		}

		private static void phoneLC(String s, String ans) {
			
			if(s.isEmpty()) {
				System.out.println(ans);
				return;
			}
			
			String keys=keypad[s.charAt(0)-48];
			
			for(int i=0; i<keys.length();i++) {
				phoneLC(s.substring(1),ans+keys.charAt(i));
			}
			
		}
}
