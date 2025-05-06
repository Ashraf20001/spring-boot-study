package com.problems.strings;

import java.util.Arrays;

public class LongestPalindromicLength {
    public static void main(String[] args) {
            String[] strs = {"dog","racecar","car"};
           System.out.println(longestCommonPrefix(strs));

        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("Mr John Smith"));

        System.out.println(longestPalindromicLength("geeks"));
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

       for(int k=3;k<=n;k++){
           for(int i=0;i<n-k+1;i++){ // starting index
               int j=k+i-1;  // ending index
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
