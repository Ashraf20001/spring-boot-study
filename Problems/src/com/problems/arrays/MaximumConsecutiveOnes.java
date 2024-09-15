package com.problems.arrays;

public class MaximumConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 1, 3, 3, 3, 1, 1, 1, 4, 4, 4};
        long l = System.currentTimeMillis();
        countConsecutiveOnes(arr);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    private static void countConsecutiveOnes(int[] arr) {
        int count = 0;

        int maxCount = 0;
        for (int el : arr) {
            if (el == 1) {
                count++;
            } else {
//                maxCount = Math.max(count, maxCount);
                if(count>maxCount){
                    maxCount=count;
                }
                count = 0;

            }
        }
        System.out.println(maxCount);
    }
}
