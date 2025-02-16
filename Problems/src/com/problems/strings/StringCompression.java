package com.problems.strings;

import java.util.Arrays;
import java.util.Objects;

public class StringCompression {
    public static void main(String[] args) {


        char[] s = {'a','a','b','b','c','c','c'};
//        char[] s = {'a','b','c'};
//        char[] s = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b'};

        System.out.println(compressedString(s));

        for(char ch: s){
            System.out.print(ch+" ");
        }

    }

    private static int compressedString(char[] s) {
        int count = 0;

        int j= 0;

        if(s.length == 1){
            return s.length;
        }

        int i=0;
        while(i<s.length){
            char currentChar = s[i];
            while(i<s.length && s[i]==currentChar){
                count++;
                i++;
            }

            s[j++]=currentChar;

            if(count > 1){
                String ans = count+"";

                for(int k=0;k<ans.length();k++){
                    s[j++]=ans.charAt(k);
                }
                count = 0;
            }else{
                count = 0;
            }
        }


        return j;
    }
}
