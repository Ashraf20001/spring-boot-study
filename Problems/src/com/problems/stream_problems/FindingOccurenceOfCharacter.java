package com.problems.stream_problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FindingOccurenceOfCharacter {
    public static void main(String[] args) {
        String str= "abcdefghijkklmnopqrstuvwxyz";
        char c = 'e';

        IntStream characters = str.chars();

        System.out.println(characters.filter(el->el == c).count());


        // Second most repeated character in a string


        System.out.println(str.chars().mapToObj(el->(char)el).collect(Collectors.groupingBy(el->el,Collectors.counting())).entrySet()
                .stream().sorted(Map.Entry.<Character,Long>comparingByValue().reversed()).
                map(Map.Entry::getKey).skip(1).findFirst().orElse(' '));

//        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
//        Spliterators.spliterator(iterator,10,Spliterator.ORDERED);           // With size known
//        Spliterator<String> stringSpliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.NONNULL);  // With unknown size
//        Stream<String> stream = StreamSupport.stream(stringSpliterator, false);
//
//        Iterator<String> iterator1 = stream.iterator();
//
//        while(iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }

    }
}
