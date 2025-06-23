package com.problems.arrays.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayOfZerosAndOnesLength {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1};
        System.out.println(findContiguousArrayLength(arr));

    }

    private static int findContiguousArrayLength(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int subArrl = 0;
        int sum = 0;

        map.put(0, -1); // Initialize to handle sum == 0 case

        for (int i = 0; i < n; i++) {
            // Convert 0 to -1 to balance 1s and 0s
            if (arr[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                subArrl = Math.max(subArrl, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return subArrl;
    }


}
