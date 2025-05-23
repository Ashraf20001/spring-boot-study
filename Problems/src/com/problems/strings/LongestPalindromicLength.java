package com.problems.strings;

import java.util.Arrays;

public class LongestPalindromicLength {
    public static void main(String[] args) {
            String[] strs = {"dog","racecar","car"};
           System.out.println(longestCommonPrefix(strs));

        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("Mr John Smith"));

        System.out.println(longestPalindromicLength(""));
        // Expand substring
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int ind=0;
        while(ind<s1.length() && ind < s2.length()){
            if(s1.charAt(ind)==s2.charAt(ind)){
                ind++;
            }
            else{
                break;
            }
        }
        return s1.substring(0,ind);
    }

    public static String longestPalindromicLength(String s){
       boolean[][] dpTable = new boolean [s.length()][s.length()];

       int n = s.length();

       if(n == 1 || n== 0){
           return s;
       }

       int start =0,maxlength = 1;
       for(int i=0;i<n;i++){
           dpTable[i][i]=true;
       }

       for(int i=0;i<n-1;i++){
           if(s.charAt(i)==s.charAt(i+1)){
               dpTable[i][i+1]=true;
               if(maxlength<2){
                   start=i;
                   maxlength = 2;
               }
           }
       }

       // substring for length greater than 3

       for(int k=3;k<=n;k++){         // length range
           for(int i=0;i<n-k+1;i++){ // starting index range
               int j=k+i-1;  // ending index range
               if(dpTable[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                   dpTable[i][j]=true;
                   if(k>maxlength){
                       maxlength = k;
                       start = i;
                   }
               }

           }
       }
        System.out.println("Max length "+maxlength);
       return s.substring(start,start+maxlength);


    }

    static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int start = 0, maxLen = 1;

        // Traverse the input string
        for (int i = 0; i < n; i++) {

            // THIS RUNS TWO TIMES
            // for both odd and even length
            // palindromes. j = 0 means odd
            // and j = 1 means even length
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;

                // Expand substring while it is a palindrome
                // and in bounds
                while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                    int currLen = high - low + 1;
                    if (currLen > maxLen) {
                        start = low;
                        maxLen = currLen;
                    }
                    low--;
                    high++;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}

class ReplaceSpace{

    public String replaceSpace(String s){
        char[] oldArray = s.toCharArray();
        int count = 0;
        for(char ch : oldArray){
            if(Character.isWhitespace(ch)){
                count++;
            }
        }

        int newArrayLength = oldArray.length + count *2;  // To accomodate space;

        char[] newChar = new char[newArrayLength];
        int newCharIndex = 0;
        int i=0;
        while(i<oldArray.length && newCharIndex < newArrayLength){
            if(Character.isWhitespace(oldArray[i])){
                newChar[newCharIndex++]='%';
                newChar[newCharIndex++]='2';
                newChar[newCharIndex++]='0';
                i++;
            }else{
                newChar[newCharIndex++]=oldArray[i++];
            }
        }

        return new String(newChar);

    }
}
