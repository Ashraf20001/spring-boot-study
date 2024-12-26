package com.problems.function;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMethods {

    public List<Countries> prepareCountries(){
        List<Countries> countries = new ArrayList<>();
        countries.add(new Countries("America",20));
        countries.add(new Countries("Russia",30));
        countries.add(new Countries("China",10));
        countries.add(new Countries("Singapore",15));
        countries.add(new Countries("Lebanon",23));
        countries.add(new Countries("Indonesia",25));
        countries.add(new Countries("United Kingdom",20));
        countries.add(new Countries("China",19));
        countries.add(new Countries("America",30));

        return countries;
    }

    public void toCollectExample(){
        HashSet<Countries> countriesHashSet = prepareCountries().stream().filter(el -> el.temperature() > 15)
                .collect(Collectors.toCollection(HashSet::new));
        countriesHashSet.forEach(System.out::println);
    }

    public void toMapExample(){
//        System.out.println(prepareCountries().stream().filter(el->el.temperature() > 15)
//                .collect(Collectors.toMap(Countries::name,Countries::temperature)));  // If duplicate keys are there, It would throws IllegalStateException
        System.out.println(prepareCountries().stream().filter(el->el.temperature()>15)
                .collect(Collectors.toMap(Countries::name,Countries::temperature,(name,temp)->temp)));

    }

    public void collectingAndThen(){
        System.out.println(prepareCountries().stream().collect(Collectors.groupingBy(Countries::name,Collectors.summingInt(Countries::temperature))));
        // groupBy will always produce map result. This second argument will help to do additional reduction operation from collectors
        System.out.println(
                prepareCountries()
                        .stream()
                        .collect(Collectors.collectingAndThen(Collectors.counting(), Long::intValue))
        );

        List<Integer> collected = Stream.of(3, 6, 9).collect(Collectors.collectingAndThen(Collectors.toList(),List::copyOf));
        System.out.println(collected);

    }

    public void joining(){
        System.out.println(prepareCountries().stream().map(Countries::name).collect(Collectors.joining(",")));
    }

    public void partitioning(){
        System.out.println(prepareCountries().stream().collect(Collectors.partitioningBy(countries->countries.temperature()>15
        ,Collectors.mapping(Countries::name,Collectors.toList()))));

        System.out.println(prepareCountries().stream().collect(Collectors.partitioningBy(countries->countries.temperature()>15
                ,Collectors.counting())));
    }

    public void printMaximumTemperature(){
        System.out.println(prepareCountries().stream().collect(Collectors.maxBy(Comparator.comparing(Countries::temperature))));
    }

    public static void main(String[] args) {
        CollectorsMethods collectorsMethods = new CollectorsMethods();
       collectorsMethods.printMaximumTemperature();
    }
}

record Countries(String name, Integer temperature) {};
