package com.problems.streamapiproblems;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondMostRepeatingChar {
    public static void main(String[] args) {
        String str = "aaabdcc";


        java.lang.Character character = str.chars()
                .mapToObj(el -> (char) el)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1).findFirst().map(Map.Entry::getKey).orElse('0');

        System.out.println(character);

    }
}
