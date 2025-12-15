package com.problems.stream_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AverageSlidingWindow {
    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(14);
        integerArrayList.add(21);
        integerArrayList.add(10);
        integerArrayList.add(61);

        int window = 2;

        List<Integer> list = IntStream.range(0, integerArrayList.size() - window + 1)
                .mapToObj(intElement -> (integerArrayList.get(intElement) + integerArrayList.get(intElement + 1))/window)
                .toList();
        System.out.println(list);
        System.out.println(Stream.iterate(0,el->el+1).limit(integerArrayList.size()-window+1)
                        .map(i->(integerArrayList.get(i)+integerArrayList.get(i+1))/window)
                        .toList());

        // Generic approach

        System.out.println(IntStream.range(0, integerArrayList.size() - window + 1)
                .mapToObj(i->integerArrayList.subList(i,i+window))
                .map(el->el.stream().mapToInt(Integer::intValue).average())
                .filter(OptionalDouble::isPresent)
                .map(OptionalDouble::getAsDouble)
                .toList());


    }
}
