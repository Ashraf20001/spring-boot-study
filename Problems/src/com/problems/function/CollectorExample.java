package com.problems.function;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorExample {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "3", "4", "5");
//        StringBuilder collect = strings.parallelStream().collect(() -> new StringBuilder(), (acc, builder) -> acc.append(builder), (x, y) -> x.append(",").append(y));
        StringBuilder collect = strings.parallelStream().collect(StringBuilder::new, StringBuilder::append, (x, y) -> x.append(",").append(y));
        Map<String, Integer> collect1 = strings.stream().collect(Collectors.toMap(Function.identity(), Integer::parseInt));
        System.out.println(collect.toString());
    }
}
