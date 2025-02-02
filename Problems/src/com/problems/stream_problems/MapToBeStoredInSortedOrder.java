package com.problems.stream_problems;

import java.util.*;
import java.util.stream.Collectors;

public class MapToBeStoredInSortedOrder {
    public static void main(String[] args) {
        List<Notes> notes = new ArrayList<>();
        notes.add(new Notes(1, "note1", 11));
        notes.add(new Notes(2, "note2", 22));
        notes.add(new Notes(3, "note3", 33));
        notes.add(new Notes(4, "note4", 44));
        notes.add(new Notes(5, "note5", 55));

        notes.add(new Notes(6, "note4", 66));

        Map<String, Integer> collect = notes.stream()
                .sorted(Comparator.comparingInt(Notes::pageNo).reversed())
                .collect(Collectors.toMap(Notes::notesName, Notes::pageNo, (pageNo1, pageNo2) -> pageNo1, LinkedHashMap::new));

        //  Objects with not null values

        System.out.println(Optional.ofNullable(notes)
                .orElseGet(Collections::emptyList)
                .stream().filter(Objects::nonNull)
                .toList());

        System.out.println(collect);

    }
}

record Notes (Integer id, String notesName , Integer pageNo){}
