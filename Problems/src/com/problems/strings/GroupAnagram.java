package com.problems.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strArr= {"ate","tea","bat","tan","tab","eat"};
        ArrayList<ArrayList<String>> x = groupAnagram(strArr);
        Collections.sort(x, Comparator.comparingInt(ArrayList::size));
        System.out.println(x);
    }

    private static ArrayList<ArrayList<String>> groupAnagram(String[] strArr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, Integer> stringFrequencyMap = new HashMap<>();
        for (String string : strArr) {
            String s = anagramHash(string);
            if (!stringFrequencyMap.containsKey(s)) {
                stringFrequencyMap.put(s, res.size());
                res.add(new ArrayList<>());
            }
            res.get(stringFrequencyMap.get(s)).add(string);
        }
        return res;
    }

    private static String anagramHash(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] freq =  new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int el : freq){
            stringBuilder.append(el);
            stringBuilder.append("#");
        }
        return new String(stringBuilder);
    }
}
