package com.problems.arrays.tp_approach;

public class LongestAlternativeOddEvens {
    public static void main(String[] args) {
            int[] arr={8,10,6,2};
            System.out.println(calculateLongOddEvenUsingNaiveApproach(arr));
    }

    private static int calculateLongOddEvenUsingNaiveApproach(int[] arr) {
            int maxCount=0;
            int count=1;
            for(int i=0; i<arr.length-1; i++){
               if(arr[i]%2==0 && arr[i+1]%2!=0
                   || arr[i]%2!=0 && arr[i+1]%2==0){
                   count++;
                   continue;
               }
               maxCount=Math.max(count,maxCount);
               count=1;

            }

            return Math.max(count,maxCount);
    }
}
