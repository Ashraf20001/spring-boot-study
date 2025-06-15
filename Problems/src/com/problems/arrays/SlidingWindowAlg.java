package com.problems.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SlidingWindowAlg {
    public static void main(String[] args) {
        int[] arr={2,9,31,-4,21,7};
        System.out.println(findMaximumSubArrayOfLengthK(arr,3));
    }

    private static int findMaximumSubArrayOfLengthK(int[] arr, int k) {
        int wSum=0; int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<k ;i++){
            wSum+=arr[i];
        }
        maxSum=Math.max(wSum,maxSum);
        for(int i=k; i<arr.length; i++){
            wSum=wSum-arr[i-k]+arr[i];
            maxSum=Math.max(wSum,maxSum);
        }
        return maxSum;
    }

    private static long findMaximumDistinctSubArrayOfLengthK(int[] arr, int k) {
        long currentSum = 0;
        long maxSum = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Fixed left initially at start 0
        int l = 0;
        for(int r=0; r<arr.length;r++){
            // Window creating
            currentSum+=arr[r];
            frequencyMap.put(arr[r], frequencyMap.getOrDefault(arr[r],0)+1);

            while(frequencyMap.get(arr[r])>1 || (r-l+1) >k ){
                currentSum-=arr[l];
                frequencyMap.put(arr[l], frequencyMap.get(arr[l]) - 1);
                if (frequencyMap.get(arr[l]) == 0) {
                    frequencyMap.remove(arr[l]);
                }
                l++;
            }

            if(r-l+1 == k){
                maxSum = Math.max(currentSum,maxSum);
            }
        }
        return maxSum;

        /*
             HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        long maxSum = 0;
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            while (set.contains(arr[j])) {
                set.remove(arr[i]);
                sum -= arr[i];
                i++;
            }

            set.add(arr[j]);
            sum += arr[j];

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                set.remove(arr[i]);
                i++;
            }
        }

        return maxSum;
         */

        /*

             Set<Integer> set = new HashSet<>();
        long maxSum = 0, windowSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                // Remove leftmost element until we can add nums[right]
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            windowSum += nums[right];

            // If window size is exactly k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                // Slide window forward
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
        }

        return maxSum;
         */
    }
}
