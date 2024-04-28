package com.problems.bitmanipulation;

public class NthPalindromicBinary {

    public static void main(String[] args) {
        int n =10; 
        int result = findNthPalindromicBinary(n);
        System.out.println("The " + n + "th palindromic binary representation is: " + Integer.toBinaryString(result));
    }


    private static int findNthPalindromicBinary(int n) {
    		
    	// find length and count ( position of previous length's last palindromic progression)
    	
    	int l=0,count=0;
    	while(count<n) {
    		l++;
    		count+=Math.pow(2,((l-1)/2));
    	}
    	
    	count-=Math.pow(2,((l-1))/2);  // we are subtracting the last count addition so that it 
    								  //	would sync with previous length's last palindromic progression
    	
    	// Find the element of nth palindrome around the permutation set of the length obtained
    	
    	int element= n - count -1;
    	
    	// Contruct half answer using element and length;
    	
    	int ans= 1<< l-1 | element << (l/2);
    	
    	// Generate final result
    	
    	return ans | ReverseBinaryBits.revBits(ans,l);
    	
    }
}

