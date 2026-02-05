package com.problems.arrays.greedy_pattern;

public class JumpingGame1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 0, 0};
        System.out.println(canReachEnd(arr));
    }

    private static boolean canReachEnd(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if(max<i)
                return false;
            max = Math.max(max,i+arr[i]);
        }

        return true;
    }
}
