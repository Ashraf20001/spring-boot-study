package com.problems.arrays.sorting.alg;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 0};
        insertionSort(arr);
        for (int ar : arr) {
            System.out.print(ar);
            System.out.print(" ");
        }
    }
}
    // Notes

    /*
        In Insertion sort  , element after i th position is considered as unsorted array
        whereas before ith elements are sorted array.

        Now pick i th element and consider it as key. j must be always one position behind of i
        , for eg: if i=1; j=i-1, (always i will be from 1 )
        1. check if jth element is greater than ith element and j is greater than 0,
        2. if it satisfies, shift "jth element" to one step ahead.( arr[j+1] =arr[j] ) and  move j backward,
        3. continue this until check condition fails,
        4. then place key element at one step before final position of j ( arr[j+1] = key )

        Repeat these 4 until "i" reaches end of the array

        thus array get sorted in ascending order

        Time complexity for insertion sort:
        Best case : O (n)
        Worst case : O(n*n)
     */
