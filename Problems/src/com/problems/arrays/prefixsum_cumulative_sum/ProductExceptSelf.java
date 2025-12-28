package com.problems.arrays.prefixsum_cumulative_sum;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums ={2,3,5,0};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static int[] productExceptSelf(int[] nums) {
            int[] newArr = new int[nums.length];
            Arrays.fill(newArr,1);          // Initialize all element of the array as 1
            int current =1;

            for(int i=0; i< nums.length ; i++){
                newArr[i]= newArr[i] * current;
                current = current * nums[i];
            }

            current = 1;

        for (int i = nums.length-1; i >= 0 ; i--) {
            newArr[i] = newArr[i] * current;
            current = current * nums[i];
        }

        return newArr;

    }

}
