package com.problems.arrays.prefixsum_cumulative_sum;

public class PrintAllSubArrays {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printAllSubArrays(arr);
    }

    private static void printAllSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}