package com.problems.arrays.sorting.alg;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={4,1,3,2};
        mergeSort(arr,0,arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }

    private static void mergeSort(int[] arr, int l, int h) {
        if(l==h) return;   // basecase (indicate there is single length array)
        int mid= (l+h)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,h);
        int[] arr1= new int[mid-l+1];
        int[] arr2= new int[h-mid];

        int i=0; // arr1
        int j=0; // arr2

        for(;i<arr1.length;i++){
            arr1[i]=arr[l+i];
        }
        for(;j<arr2.length;j++){
            arr2[j]=arr[mid+1+j];
        }
        sortArray(arr1, arr2, arr,l);
    }

    private static void sortArray(int[] arr1, int[] arr2, int[] arr,int start) {
        int i=0,j=0,k=start;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];

            }
            else{
                arr[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            arr[k++]=arr1[i++];
        }
        while(j<arr2.length){
            arr[k++]=arr2[j++];
        }
    }
}

/*
        Time complexity
        O(nlogn)
        Most efficient way of sorting
 */