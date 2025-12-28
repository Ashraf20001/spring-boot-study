package com.problems.arrays.interval_based_pattern;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3}};
        int nonOverlappedIntervals = getNonOverlappingIntervalCount(intervals);
        System.out.println(nonOverlappedIntervals);
    }

    private static int getNonOverlappingIntervalCount(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int previousElement = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (previousElement <= intervals[i][0]) {
                previousElement = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;

    }
}
