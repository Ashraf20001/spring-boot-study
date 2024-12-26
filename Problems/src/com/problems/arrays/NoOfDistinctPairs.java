package com.problems.arrays;

import java.util.*;

public class NoOfDistinctPairs {

    public static void main(String[] args) {
        int[]  arr= {1,1,1,1};
        int target = 2;

        System.out.println(noOfDistinctPairs(arr,target));
    }

    private static List<List<Integer>> noOfDistinctPairs(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            int complement = target - arr[i];

//                    complement exist only once && complement is equal to element
            if(frequencyMap.getOrDefault(complement,0)==1 && complement==arr[i]){
                res.add(Arrays.asList(arr[i],arr[i]));
                // complement exist more than once but element should not exist
            }else if(frequencyMap.getOrDefault(complement,0)>0 && !frequencyMap.containsKey(arr[i])){
                int first = Math.min(arr[i],complement);
                int second = Math.max(arr[i],complement);
                res.add(Arrays.asList(first,second));
            }

            frequencyMap.put(arr[i],frequencyMap.getOrDefault(arr[i],0)+1);
        }

        return res;
    }
}
