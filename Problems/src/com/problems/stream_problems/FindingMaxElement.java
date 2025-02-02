package com.problems.stream_problems;

import java.util.Arrays;
import java.util.List;

public class FindingMaxElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
//        list.stream().mapToInt(el->el).max().ifPresent(System.out::println);

        System.out.println(list.stream().max(Integer::compareTo).get());


    }
}
