package com.problems.stream_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindingFirstNonRepeatingCharacter {
    public static void main(String[] args) {

        String str= "Java articles are Awesome";

       str.chars().mapToObj(el->(char)el).collect(Collectors.groupingBy(el->el,LinkedHashMap::new,Collectors.counting()))
               .entrySet().stream().filter(el->el.getValue()==1L).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);

       // First repeating character

        str.chars()
                .mapToObj(el->(char)el)
                .filter(el -> str.indexOf(el)!=str.lastIndexOf(el))    // Here we can add setAdd approach which
                .findFirst()                                          //  return false booleans are repeating characters
                .ifPresent(System.out::println);

        System.out.println(str.chars().mapToObj(el->(char)el).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())
        ).entrySet().stream().max(Map.Entry.comparingByValue()).stream().findFirst().get().getKey());

        String[] strArrays = {"ABC","DEF","CHI","LMN","OOP","CHI"};
        System.out.println(Arrays.stream(strArrays).map(el->el.substring(0,1))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
    }
}
