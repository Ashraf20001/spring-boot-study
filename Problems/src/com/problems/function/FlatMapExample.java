package com.problems.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {
        List<List<Integer>> objects = new ArrayList<>();

        List<Integer> integerList1 = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();

        for (int i = 1; i <=10; i++) {
            integerList1.add(i);
            integerList2.add(i);
        }

        objects.add(integerList1);
        objects.add(integerList2);

        objects.stream().flatMap(List::stream).collect(Collectors.toList());  // It returns stream consists of elements produced by result of function of mapped stream.
    }
}
