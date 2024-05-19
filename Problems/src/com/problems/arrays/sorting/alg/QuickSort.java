package com.problems.arrays.sorting.alg;

public class QuickSort {

    public static void main(String[] args) {
            int[] arr={2,1,6,4,5};
            quickSort(arr,0,arr.length-1);
            for(int i: arr){
                System.out.print(i);
                System.out.print(" ");
            }
    }

    private static void quickSort(int[] arr, int l, int h) {
        if(l<h){
            int piv=partition(arr,l,h); // partition
            quickSort(arr,l,piv-1);
            quickSort(arr,piv+1,h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        int j = l;
        while (j < arr.length) {
            if (arr[j] < pivot) {
                i++;
                swapArray(arr, i, j);
            }
            j++;
        }
        swapArray(arr, i + 1, h);
        return i + 1;
    }

    private static void swapArray(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

/*
    Notes:
        In quick sort, we have pivot element which must be at end.
        we have two indices
        1. i, which is one step behind j at first time
        2. j, which is at  0th index at first time
        3. we need to start compare jth element with pivot.
        4. if jth element is lesser than pivot, move i forward and swap i with j, then move j forward.
        5. if not move j alone forward.
        6. continue above steps in loop until j reaches end
        7. once j reached pivot, swap i+1 with pivot
        8. return i+1 which indicates the position of pivot element;
        9. Partition the array with return i+1 position
        10.do same operation on both partitioned arrays recursively.

        Best case O(nlogn)
        Worst case O(n*n)
 */
