package com.problems.arrays;

public class FindOccurenceOfElements {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,3};
        findFrequency(arr);
    }

    private static void findFrequency(int[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                System.out.println(arr[i] + "occurs " + count + " times");
                count = 1;
            } else {
                count++;
            }
        }
        if (count >=1) {
            System.out.println(arr[arr.length - 1] + "occurs " + count + " times");
        }
    }
}
