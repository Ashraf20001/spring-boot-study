package com.problems.recursion;

public class PermutationOfString {
			public static void main(String[] args) {
				String s="abcd";
				printPermutations(s.toCharArray(),0);
				System.out.println("combinations");
				combinations(s.toCharArray(), 0);
			}

			 static void printPermutations(char[] s, int fi) {
				if(fi==s.length-1) {
					System.out.println(s);
					return;
				}
				 /**
				  * If we put base condition as fi == s.length, the previous stack will have fi = s.length-1
				  * and in for loop i will be increased by 1 from fi. Hence , while swapping it could cause array index
				  * out of bound exception because it will try to swap element 3 with element 4 as there is no element 4 in array
				  */

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
