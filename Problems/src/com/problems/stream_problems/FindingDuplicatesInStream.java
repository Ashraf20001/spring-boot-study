package com.problems.stream_problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindingDuplicatesInStream {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);

//        Set Approach

//        HashSet<Object> set = new HashSet<>();
//        System.out.println(integerStream.filter(el->!set.add(el)).collect(Collectors.toSet()));


        // Grouping by approach
//        System.out.println(integerStream.collect(Collectors.groupingBy(el->el,Collectors.counting())).entrySet().stream().filter(el->el.getValue()>1).map(Map.Entry::getKey).toList());

        // Frequency Approach
        List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        System.out.println(integerStream.filter(el-> Collections.frequency(list,el)>1).collect(Collectors.toSet()));
    }
}
