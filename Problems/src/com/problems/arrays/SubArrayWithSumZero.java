package com.problems.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SubArrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 1, 6};
        lengthOfTheSubArrayWithSumZero(arr);
    }

    private static void lengthOfTheSubArrayWithSumZero(int[] arr) {
        Map<Integer, Integer> prefixLengthSum = new HashMap<>();
        int sum=0;
        int length=0;

        for(int i=0; i<arr.length ; i++){
            sum+=arr[i];
            if(sum == 0){
                if(arr[i] == 0){
                    length = 1;
                }else{
                    length = i+1;
                }
            }
            if(prefixLengthSum.containsKey(sum)) {
                length = Math.max(length,i-prefixLengthSum.get(sum));
            }

            prefixLengthSum.put(sum,i);
        }

        System.out.println(length);
    }

}
