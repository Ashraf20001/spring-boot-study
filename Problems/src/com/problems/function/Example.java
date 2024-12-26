package com.problems.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<Character> characterList = new ArrayList<>();
        Stream.iterate(1,element->element+20)
                .limit(5).forEach(el->characterList.add(new Character("Boys",el)));

        characterList.forEach(System.out::println);

//        Character[name = Boys, age = 1]
//        Character[name = Boys, age = 21]
//        Character[name = Boys, age = 41]
//        Character[name = Boys, age = 61]
//        Character[name = Boys, age = 81]

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ashraf",0,4);
        System.out.println(new String(stringBuilder));

        // Ashr

        

    }

}



record Character (String name, Integer age){};
