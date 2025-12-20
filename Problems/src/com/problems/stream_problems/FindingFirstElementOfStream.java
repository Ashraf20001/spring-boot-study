package com.problems.stream_problems;

import java.util.stream.Stream;

public class FindingFirstElementOfStream {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Geek First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last");
        System.out.println(stringStream.reduce((first,second)->first).orElse("No value"));

    }
}
