package com.problems.stream_problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReversingString {
    public static void main(String[] args) {
        String s = "I love java";
        String[] words= s.split(" ");
        System.out.println(Arrays.stream(words).map(el-> {
            StringBuilder stringBuilder = new StringBuilder(el);
            return stringBuilder.reverse();

        }).collect(Collectors.joining(" ")));

        // Without using StringBuilder

        System.out.println(Arrays.stream(s.split(" "))
                .map(word->Arrays.stream(word.split(""))
                        .reduce("",(a,b)->b+a)
                ).collect(Collectors.joining(" ")));

    }

}
