package com.problems.arrays;

public class MaximumSubArraySum {

    // Kadane's Algorithm
    public static void main(String[] args) {
        int[] arr = {100, -1, -3, -4, -1, -2, -1, -5, 4};
        System.out.println(calculateMaxSubArray(arr));
    }

    private static int calculateMaxSubArray(int[] arr) {
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
