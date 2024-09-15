package com.problems.recursion;

public class ReverseSting {
		public static void main(String[] args) {
			String str="absxg";
//			String revStr=reverseString(str);
			String  str1=" manonmani ";
			String revStr= reverseString(str,"",str.length()-1);
			System.out.println(reverseSentence(str1,"",str1.length()-1,0,str1.length()));
			System.out.println(revStr);
		}

	private static String reverseSentence(String str1,String res,int i,int start, int end) {

			if(res=="" && i==0){
				return str1;
			}else if(i<0) {
				return res;
			}else if(str1.charAt(i)==' ' && i!=str1.length()-1){
				start=i+1;
				res+=str1.substring(start,end)+ str1.charAt(i);
				end=i;
			}else if(i==0 && !res.isEmpty()){
				res+=str1.charAt(i);
			}
			return reverseSentence(str1,res,i-1,start,end);
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
