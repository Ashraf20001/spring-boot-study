package com.problems.arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutAuxillarySpace {
    public static void main(String[] args) {
        int[] arr1={5,8,9,12};
        int[] arr2={2,6,7};
//        mergeTwoSSortedArraysUsingNaiveApproach(arr1,arr2);
//        mergeTwoSortedArraysUsingEff1(arr1,arr2);
        mergeTwoSortedArraysUsingEff2(arr1,arr2);
        System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));
    }

    private static void mergeTwoSortedArraysUsingEff1(int[] arr1, int[] arr2) {
        int i=0;int j=0; int k=arr1.length-1;
        while(i< arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            }else{
                int temp=arr1[k];
                arr1[k]=arr2[j];
                arr2[j]=temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    private static void mergeTwoSSortedArraysUsingNaiveApproach(int[] arr1, int[] arr2) {
        for (int j = arr2.length - 1; j >= 0; j--) {
            int lastElem = arr1[arr1.length - 1];
            int i = 0;
            for (i = arr1.length - 2; i >= 0 && arr1[i] > arr2[j]; i--) {
                arr1[i + 1] = arr1[i];                                      // Insertion sort
            }
            if (lastElem > arr2[j]) {
                arr1[i + 1] = arr2[j];                                      // Insertion sort
                arr2[j] = lastElem;                                         // Assign large elements at the second array

            }
        }
    }

    private static void mergeTwoSortedArraysUsingEff2(int[] arr1,int[] arr2){
        int i=0;
        int temp=0;

        while(arr1[arr1.length-1]>arr2[0]){
            if(arr1[i]>arr2[0]){
                temp=arr1[i];
                arr1[i]=arr2[0];
                arr2[0]=temp;
                Arrays.sort(arr2);
            }
            i++;
        }
        Arrays.sort(arr1);
    }

}
