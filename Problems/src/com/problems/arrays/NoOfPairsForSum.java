package com.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoOfPairsForSum {
    public static void main(String[] args) {
              int[]  arr= {1, 5, 7, -1, 5};
              int target = 6;

           System.out.println(twoPointerApproach(arr,target));

           System.out.println(hashMapApproach(arr,target));
    }

    private static int hashMapApproach(int[] arr, int target) {
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hashMap.containsKey(target-arr[i])){
                count+=hashMap.get(target-arr[i]);
            }

            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        return count;
    }

    private static int twoPointerApproach(int[] arr, int target) {
            int l = 0;
            int h = arr.length-1;

            Arrays.sort(arr);

            int res = 0;

            while(l<h){
                if(arr[l]+arr[h] < target){
                    l++;
                }else if(arr[l]+arr[h] > target){
                    h--;
                }else{
                    int count1 =0; int count2 =0;
                    int el1= arr[l]; int el2 = arr[h];

                    while(l<=h && arr[l]==el1){
                        l++;
                        count1++;
                    }

                    while (h>=l && arr[h]==el2){
                        h--;
                        count2++;
                    }

                    if(el1==el2){
                        res += (count1 * (count1 -1))/2;    // Combination
                    }
                    else{
                        res += count1*count2;      // product of two counts is the total count of pairs
                    }
                }
            }

            return res;
    }
}
