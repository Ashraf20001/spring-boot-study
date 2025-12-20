package com.problems.arrays.thrp_algorithm;

import java.util.Arrays;

public class SwapElementsWithThreePhase {
    public static void main(String[] args) {
       int[] arr = {1, 1, 2, 2, 0, 0};

       int i=0;
       int j=0;
       int k = arr.length -1;

       while(j<=k){
           if(arr[j] == 1){
               j++;
           }
           else if(arr[j] == 0){
               swap(arr,j,i);
               i++;
               j++;
           } else if (arr[j] == 2) {
               swap(arr,j,k);
               k--;
           }

       }

        Arrays.stream(arr).forEach(el->System.out.print(el+" "));
    }

    private static void swap(int[] arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
