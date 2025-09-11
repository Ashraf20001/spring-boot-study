package com.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int nonOverlappedIntervals = getNonOverlappingIntervalCount(intervals);
        System.out.println(nonOverlappedIntervals);
    }

    private static int getNonOverlappingIntervalCount(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        List<int[]> intervalsList = new ArrayList<>();
        intervalsList.add(intervals[0]);
        int overlappingCount = 0;
        for (int i=1; i<intervals.length ; i++){

                if(intervalsList.getLast()[1]<=intervals[i][0]){
                    intervalsList.add(intervals[i]);
                }else {
                    overlappingCount++;
                }
            }

        return overlappingCount;
        }
}
