package com.problems.arrays;

public class FindMinAndMax {
    public static void main(String[] args) {
        int[] A = { 4, 9, 6, 5, 2, 3 };

        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;

        for (int el: A){
            min = Math.min(min,el);
            max = Math.max(max,el);
        }

        System.out.println("Minimum value "+ min);
        System.out.println("Maximum value "+max);
    }
}
