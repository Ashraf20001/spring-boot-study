package com.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {

    public static void main(String[] args) {
        String s1="heart"; String s2 = "earth";

        if(isAnagram(s1,s2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> frequencyCheckMap = new HashMap<>();

        for(int i=0; i<s1.length();i++){
            frequencyCheckMap.put(s1.charAt(i),frequencyCheckMap.getOrDefault(s1.charAt(i),0)+1);
        }

        for (int i = 0; i <s2.length(); i++) {
            if(frequencyCheckMap.containsKey(s2.charAt(i))){
                frequencyCheckMap.put(s2.charAt(i),frequencyCheckMap.get(s2.charAt(i))-1);
            }
        }

        for( Map.Entry<Character,Integer> entries : frequencyCheckMap.entrySet()){
            if(entries.getValue() !=0){
                return false;
            }
        }

        return true;


        // run time 1ms

//        int[] count = new int[26];
//        for(char c : s.toCharArray()){
//            count[c - 'a']++;
//        }
//        for(char c1 : t.toCharArray()){
//            count[c1 - 'a']--;
//        }
//
//        for(int val : count){
//            if(val != 0){
//                return false;
//            }
//        }
//        return true;
    }
}
