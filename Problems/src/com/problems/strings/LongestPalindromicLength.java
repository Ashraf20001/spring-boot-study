package com.problems.strings;

import java.util.Arrays;

public class LongestPalindromicLength {
    public static void main(String[] args) {
            String[] strs = {"dog","racecar","car"};
           System.out.println(longestCommonPrefix(strs));

        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("Mr John Smith"));
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
