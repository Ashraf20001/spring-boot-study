package com.problems.recursion;

public class BalancedParanthesis {

	public static void main(String[] args) {
		int n=2;
		char[] arr= new char[n*2];
		balancedPar(arr,n,0,0,0);
	}

	private static void balancedPar(char[] arr, int n, int i, int o, int c) {
		if(i==arr.length) {
			
			System.out.println(arr);
			return;
		}
		
		if(o<n) {  											//  for open bracket compare o with n
			arr[i]='(';										//	at particular index put the open bracket
			balancedPar(arr, n, i+1, o+1, c);				//	call the function again with index ++ and o ++
		}																			
		if(c<o) {											//  for close bracket compare c with o
			arr[i]=')';										//	at particular index put the close bracket
			balancedPar(arr, n, i+1, o, c+1);				//  call the function again with index ++ and c ++
		}
	}
}
