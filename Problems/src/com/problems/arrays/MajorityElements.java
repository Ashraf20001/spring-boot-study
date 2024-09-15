package com.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class MajorityElements {
    // Boyer moore majority vote algorithm
    public static void main(String[] args) {
        int[] arr ={2,4,5,6,6,7,7,7,7,7};
        System.out.println(calculateMajorityElement(arr));
    }

    private static int calculateMajorityElement(int[] arr) {
        int count=1;
        int majorityElement=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]!=majorityElement){
                count--;
            }else{
                count++;
            }

            if(count==0){               // if count becomes zero, change the majority and re-initialize count
                majorityElement=arr[i];
                count=1;
            }
        }

        return majorityElement;
    }
}
