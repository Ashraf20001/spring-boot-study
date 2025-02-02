package com.problems.strings;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "leetcode";
        findFirstUnique(s);
    }

    private static void findFirstUnique(String s) {
        int[] asciiArray = new int[26];
        char[] charArray = s.toCharArray();


        for(int i=0 ; i<charArray.length ; i++){
            if(charArray[i] - 'a'>=0 && charArray[i] - 'a'< asciiArray.length ){
                asciiArray[charArray[i]-'a']++;
            } else if (charArray[i] - 'A'>=0 && charArray[i] - 'A'< asciiArray.length) {
                asciiArray[charArray[i]-'A']++;
            }
        }

        int firstUniqueIndex =-1;

        for(int i=0 ; i<charArray.length ; i++){

            if(charArray[i] - 'a'>=0 && charArray[i] - 'a'< asciiArray.length && asciiArray[charArray[i] - 'a']== 1 ){
               firstUniqueIndex = i;
               break;
            } else if (charArray[i] - 'A'>=0 && charArray[i] - 'A'< asciiArray.length && asciiArray[charArray[i] - 'A']== 1) {
                firstUniqueIndex = i;
                break;
            }
        }


        System.out.println(firstUniqueIndex);
    }


}
