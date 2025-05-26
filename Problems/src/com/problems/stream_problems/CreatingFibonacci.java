package com.problems.stream_problems;

import java.util.stream.Stream;

public class CreatingFibonacci {
    public static void main(String[] args) {
        Stream<Integer> fibonacciStream = Stream.iterate(new int[]{0, 1}, array -> new int[]{array[1], array[0] + array[1]})
                .map(el -> el[0]).limit(10);

        fibonacciStream.forEach(System.out::println);
    }
}
