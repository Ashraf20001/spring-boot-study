package com.problems.stream_problems;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Top3FrequentWords {
    public static void main(String[] args) {
        String para = "Java is great. Java is Object Oriented great. Java Streams are powerful";

        System.out.println(Arrays.stream(para.toLowerCase()
                        .replaceAll("[^a-z\\s]","")
                        .split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey).toList());
    }
}
