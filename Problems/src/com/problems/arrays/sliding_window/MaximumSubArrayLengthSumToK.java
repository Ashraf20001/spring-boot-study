package com.problems.arrays.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArrayLengthSumToK {

    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println(findSubArraySumLength(arr,k));
    }

    private static int findSubArraySumLength(int[] arr, int k) {
        int prefixSum = 0;
        int maxLength = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixSum+=arr[i];

            if(prefixSum == k){
                maxLength = i+1;
            }

            if(prefixSumMap.containsKey(prefixSum-k)){
                maxLength = Math.max(maxLength,i - prefixSumMap.get(prefixSum-k));
            }else{
                prefixSumMap.put(prefixSum,i);
            }

        }
        return maxLength;
    }

    private static int findNumberOfSubArrays(int[] arr, int k){
        int count = 0;
        int sum = 0;

        Map<Integer,Integer> prefixSum= new HashMap<Integer,Integer>();

        for(int i=0; i<arr.length ; i++){
            sum+=arr[i];

            if(sum == k){
                count++;
            }

            if(prefixSum.containsKey(sum-k)){
                count+=prefixSum.get(sum-k);
            }

            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);


        }
        return count;
    }
}
