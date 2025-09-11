package com.problems.arrays;

import java.util.*;

public class FindKthMostFrequentElements {
    public static void main(String[] args) {
        int[] res = {1,1,1,2,2,3};

        System.out.println(Arrays.toString(topKFrequentUsingBucketSorting(res,2)));
    }

        private static int[] topKFrequent(int[] nums, int k) {
            // Step 1: Frequency Map
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Step 2: Min-Heap based on frequency
            PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                    new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                minHeap.offer(entry);
                if (minHeap.size() > k) {
                    minHeap.poll(); // remove least frequent
                }
            }

            // Step 3: Extract top K frequent elements
            int[] result = new int[k];
            int i = 0;
            while (!minHeap.isEmpty()) {
                result[i++] = minHeap.poll().getKey();
            }

            return result;
        }

        private static int[] topKFrequentUsingBucketSorting(int[] nums,int k){
            List<Integer>[] res =  new List[nums.length+1];

            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            for(int i=0;i<res.length;i++){
                res[i]  = new ArrayList<>();
            }

            for(Map.Entry<Integer,Integer> el  :freqMap.entrySet()){
                res[el.getValue()].add(el.getKey());
            }

            List<Integer> resArrayList = new ArrayList<>();

            for(int i= res.length -1 ; i>=0 && resArrayList.size()<=k ; i--){
                    resArrayList.addAll(res[i]);

            }
            int[] ans = new int[k];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = resArrayList.get(i);
            }
            return ans;
        }
}
