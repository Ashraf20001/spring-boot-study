package com.problems.stream_problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertStreamToSet {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a", "b", "b", "c", "c", "c", "d", "e");
        String[] array = stringStream.toArray(String[]::new);
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set,array);
        set.forEach(System.out::println);
    }
}
