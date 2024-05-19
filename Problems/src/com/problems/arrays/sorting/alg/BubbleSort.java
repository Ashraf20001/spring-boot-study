package com.problems.arrays.sorting.alg;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr= {2, 7, 3, 5, 0};
//        int[] sorted=bubbleSort(arr,0,arr.length-1);
        System.out.print("[");
        for(int i : bubbleSort(arr)){
            System.out.print(i);
        }
        System.out.print("]");
    }


    private static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapArray(arr, j);
                }
            }
        }
        return arr;
    }


    private static void swapArray(int[] arr, int i) {
        int temp = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = temp;

    }


    /**
     * ------ Recursive approach ----
     *
     * @param arr
     * @return
     */

//    private static int[] bubbleSort(int[] arr,int i,int j) {
//        if(j==0){
//            return arr;
//        }
//        if(i==j){
//          return  bubbleSort(arr,0,j-1);
//        }
//        if(arr[i]>arr[i+1]){
//        swapArray(arr,i);
//        }
//       int[]res= bubbleSort(arr,i+1,j);
//        return res;
//    }


    /*
        Time complexity for bubble sort
        Best case - O (n)
        Worst case - O (n*n)
     */
}
