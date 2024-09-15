package com.problems.arrays;

import java.util.Arrays;

public class MaxGap {
    public static void main(String[] args) {
        int[] nums={15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        System.out.println(maximumGap(nums));
    }
    

    public static int maximumGap(int[] nums) {
        int maxGap=0; int maxGap2=0;
        if(nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nums[i]-nums[i-1]+" "+i);

            maxGap2=Math.max(nums[i]-nums[i-1],maxGap2);
        }
        maxGap=nums[nums.length-1]-nums[nums.length-2];
        System.out.println(maxGap2);
        return maxGap;
    }
}
