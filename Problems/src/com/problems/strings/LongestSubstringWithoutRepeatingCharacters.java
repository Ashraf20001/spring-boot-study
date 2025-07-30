package com.problems.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
            String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int maxLength = 0;
        int windowSize = 0;
        int i=0,j=0;
        Set<Character> set = new HashSet<>();
        while(i<s.length() && j<s.length()){
            if(!set.add(s.charAt(j))){
                while(s.charAt(i)!=s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            windowSize = j-i+1;
            if(windowSize>maxLength) maxLength=windowSize;
            j++;

        }
        return maxLength;
    }
}

