package com.problems.arrays.interval_based_pattern;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervalsWithNewElements {
    public static void main(String[] args) {
        int[][] input = {{1,2},{3,5},{6,7},{8,10},{15,18}};
        int[] newInterval = {4,8};
        List<int[]> mergedList = mergeIntervals(input,newInterval);
        int[][] array = mergedList.toArray(new int[mergedList.size()][]);
        for (int[] el: array){
            System.out.print(el[0]+" ");
            System.out.print(el[1]+" ");
            System.out.println();
        }
    }

    private static List<int[]> mergeIntervals(int[][] input,int[] newInterval) {
        List<int[]> ints = new ArrayList<>();
        int n = input.length;
        int i=0;
        // Before the new interval starts
        while(i<n && input[i][1]<newInterval[0]){
            ints.add(input[i]);
            i++;
        }
        // Merging of new interval
        while(i<n && input[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],input[i][0]);
            newInterval[1] = Math.max(newInterval[1],input[i][1]);
            i++;
        }
        ints.add(newInterval);
        // After new interval
        while (i<n && input[i][0]>newInterval[1]){
            ints.add(input[i]);
            i++;
        }
        return ints;
    }

}
