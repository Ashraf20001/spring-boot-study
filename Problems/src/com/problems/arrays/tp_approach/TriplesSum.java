package com.problems.arrays.tp_approach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriplesSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};  // -4,-1,-1,-1,2,2
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; i++) {

            // skip duplicates by checking with previous element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i+1;
            int h = nums.length - 1;
            while (l < h) {
                List<Integer> ans = new ArrayList<Integer>();
                if (nums[l] + nums[h] + nums[i] == 0) {
                    ans.add(nums[l]);
                    ans.add(nums[h]);
                    ans.add(nums[i]);
                    res.add(ans);
                    if(l<nums.length-1 && nums[l]==nums[l+1]){
                        l++;
                    } if(h>0 && nums[h]==nums[h-1]){
                        h--;
                    }
                l++;
                 h--;
                } else if (nums[l] + nums[h] < 0) {
                    l++;
                } else {
                    h--;
                }
            }

        }

        return res;
    }
}
