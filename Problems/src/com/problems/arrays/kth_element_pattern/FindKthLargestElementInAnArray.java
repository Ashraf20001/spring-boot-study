package com.problems.arrays.kth_element_pattern;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k =2;
        System.out.println(usingPQ(arr,k));
        System.out.println(usingMinMaxFrequency(arr,k));
    }

    private static Integer usingMinMaxFrequency(int[] arr, int k) {
        int minValue = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt();

        int[] count =new int[maxValue-minValue+1];

        for (int num : arr){
            count[num-minValue]++;
        }

        int remaining = k;
        for (int i= count.length-1;i>=0;i--){
            remaining -= count[i];
            if(remaining<=0){
                return i+minValue;
            }
        }
        return -1;
    }

    private static Integer usingPQ(int[] arr, int k) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        for (int el:arr){
            integerPriorityQueue.add(el);
            if(integerPriorityQueue.size()>k){
                integerPriorityQueue.poll();
            }
        }

        return integerPriorityQueue.peek();
    }
}
