package com.problems.recursion;

public class ReverseSentenceOrder {
    public static void main(String[] args) {
        String str="I am the human ";
        System.out.println(reverseOrderOfSentence(str));
    }

    private static String reverseOrderOfSentence(String str) {
        if(str.isEmpty()){
            return str;
        }
        int spaceIndex=str.indexOf(' ');
        if(spaceIndex==-1){
            return str;
        }
        String finalWord=reverseOrderOfSentence(str.substring(spaceIndex+1));
        return finalWord+" "+str.substring(0,spaceIndex);
    }
}
