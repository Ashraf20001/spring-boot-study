package com.problems.arrays.sorting.alg;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr= {2, 7, 3, 5, 0};
        selectionSort(arr);
        for (int ar: arr){
            System.out.print(ar);
            System.out.print(" ");
        }
    }


    static void selectionSort(int[] arr){
            for (int i=0; i< arr.length-1;i++){
                    int min_i=i;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]<arr[min_i]){
                        min_i=j;
                    }
                }
                swapArray(arr,min_i,i);
            }
    }

    private static void swapArray(int[] arr, int minI, int i) {
        int temp=arr[minI];
        arr[minI]=arr[i];
        arr[i]=temp;

    }
}

/*
    Notes :

    In selection sort, I am assuming the i is the minimum index in the array.
    For confirmation, I run a loop to check minimum with my current minimum index and update the index respectively
    Then the ultimate minimum index is found.
    After that  I will update my i ith element with minimum index element.
    then i value increases and that new i value becomes minimum index
    This process continues until the end of the array.

    Time complexity
    O (n*n)  in all cases
 */