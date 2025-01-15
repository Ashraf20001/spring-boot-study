package com.problems.stream_problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FindingOccurenceOfCharacter {
    public static void main(String[] args) {
        String str= "geeksforgeeks";
        char c = 'e';

        IntStream characters = str.chars();

        System.out.println(characters.filter(el->el == c).count());


        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        Spliterators.spliterator(iterator,10,Spliterator.ORDERED);
        Spliterator<String> stringSpliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.NONNULL);
        Stream<String> stream = StreamSupport.stream(stringSpliterator, false);

        Iterator<String> iterator1 = stream.iterator();

        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}
