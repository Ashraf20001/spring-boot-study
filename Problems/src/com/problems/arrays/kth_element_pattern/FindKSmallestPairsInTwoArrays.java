package com.problems.arrays.kth_element_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKSmallestPairsInTwoArrays {
    public static void main(String[] args) {
        int[] nums1= {1,1,2};
        int[]nums2 = {1,2,3};
        System.out.println(kSmallestPairs(nums1,nums2,2));
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> lists = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for (int i = 0; i < nums1.length; i++) {

            lists.offer(new int[]{nums1[i]+nums2[0],0});

        }



        while(res.size()<k && !lists.isEmpty()){
            int[] poll = lists.poll();
            int sum = poll[0];
            int pos = poll[1];
            List<Integer> integerArrayList = new ArrayList<>();
            integerArrayList.add(sum- nums2[pos]);
            integerArrayList.add(nums2[pos]);
            res.add(integerArrayList);
            if(pos+1< nums2.length){
                lists.offer(new int[]{sum-nums2[pos]+nums2[pos+1],pos+1});
            }
        }

        return res;
    }
}
