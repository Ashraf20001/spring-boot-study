package com.problems.arrays.interval_based_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        List<int[]> mergedList = mergeIntervals(input);
        int[][] array = mergedList.toArray(new int[mergedList.size()][]);
        for (int[] el: array){
            System.out.print(el[0]+" ");
            System.out.print(el[1]+" ");
            System.out.println();
        }
    }

    private static List<int[]> mergeIntervals(int[][] input) {
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        List<int[]> ints = new ArrayList<>();
        for (int[] el : input){
            if(ints.isEmpty() || ints.getLast()[1]<el[0]){
                ints.add(el);
            }else{
                ints.getLast()[1] = Math.max(ints.getLast()[1],el[1]);
            }
        }
        return ints;
    }

}
