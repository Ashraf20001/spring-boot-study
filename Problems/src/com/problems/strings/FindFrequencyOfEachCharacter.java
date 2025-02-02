package com.problems.strings;

public class FindFrequencyOfEachCharacter {

    public static void main(String[] args) {
        String s = "leetcode";
        findFrequency(s);
    }

    private static void findFrequency(String s) {
        int[] asciiArray = new int[26];
        char[] charArray = s.toCharArray();


        for(int i=0 ; i<charArray.length ; i++){
            if(charArray[i] - 'a'>=0 && charArray[i] - 'a'< asciiArray.length ){
                asciiArray[charArray[i]-'a']++;
            } else if (charArray[i] - 'A'>=0 && charArray[i] - 'A'< asciiArray.length) {
                asciiArray[charArray[i]-'A']++;
            }
        }

        for(int i=0 ; i<charArray.length ; i++){

            if(charArray[i] - 'a'>=0 && charArray[i] - 'a'< asciiArray.length){
                System.out.println(charArray[i]+ " "+asciiArray[charArray[i]-'a']);
            } else if (charArray[i] - 'A'>=0 && charArray[i] - 'A'< asciiArray.length && asciiArray[charArray[i] - 'A']== 1) {
                System.out.println(charArray[i]+ " "+asciiArray[charArray[i]-'A']);
            }
        }

    }
}

