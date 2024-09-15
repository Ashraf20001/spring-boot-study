package com.problems.arrays;

public class SlidingWindowAlg {
    public static void main(String[] args) {
        int[] arr={2,9,31,-4,21,7};
        System.out.println(findMaximumSubArrayOfLengthK(arr,3));
    }

    private static int findMaximumSubArrayOfLengthK(int[] arr, int k) {
        int wSum=0; int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<k ;i++){
            wSum+=arr[i];
        }
        maxSum=Math.max(wSum,maxSum);
        for(int i=k; i<arr.length; i++){
            wSum=wSum-arr[i-k]+arr[i];
            maxSum=Math.max(wSum,maxSum);
        }
        return maxSum;
    }
}
