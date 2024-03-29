package com.problems.recursion;

public class PermutationOfString {
			public static void main(String[] args) {
				String s="abc";
				printPermutations(s.toCharArray(),0);
				System.out.println("combinations");
				combinations(s.toCharArray(), 0);
			}

			 static void printPermutations(char[] s, int fi) {
				if(fi==s.length-1) {
					System.out.println(s);
					return;
				}
				
				for(int i=fi; i<s.length; i++) {
					swap(s,fi,i);
					printPermutations(s,fi+1);  // fixed index increment
					swap(s,fi,i);               // after return undo the swapping of array
				}
				
			}

			 static char[] swap(char[] s, int fi, int i) {
				char temp = s[fi];
				s[fi]=s[i];
				s[i]=temp;
				return s;
				
			}
			 
			 static void combinations(char[] s, int i) {
				 System.out.println(s);
				 if(i==s.length-1) {
					 return;
				 }
				 combinations(swap(s,i,i+1),i+1);
			 }
			 
}
