package com.problems.arrays.searching_binary_search_approach;

public class BitonicArraySearch {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 3, 2, 1};  // up until 10 elements are in increasing order then all are in decreasing order

        int key = 8;
        int bitonicPosition = recursiveBinarySearchForBitonicElementSearch(arr, 0, arr.length - 1);
        searchKeyWithBitonic(arr, bitonicPosition, key);

    }

    private static void searchKeyWithBitonic(int[] arr, int bitonicPosition, int key) {
        if(arr[bitonicPosition]==key){
            System.out.println(bitonicPosition+1);
        }
        int i = bitonicSearchInAscendingArray(arr, 0, bitonicPosition, key);
        int j = bitonicSearchInDescendingArray(arr, bitonicPosition+1, arr.length - 1, key);
        if(i==-1 && j==-1){
            System.out.println(-1);
        }else if(i!=-1){
            System.out.println(i+1);
        }else{
            System.out.println(j+1);
        }
    }

    private static int recursiveBinarySearchForBitonicElementSearch(int[] arr, int l, int h) {
        if (l > h) return -1;
        int mid = (l + h) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            l = mid;
        } else {
            h = mid;
        }
        return recursiveBinarySearchForBitonicElementSearch(arr, l, h);
    }

    private static int bitonicSearchInAscendingArray(int[] arr, int l, int h, int key) {
        if (l > h) return -1;
        int mid = (l + h) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            l = mid + 1;
        } else if (arr[mid] > key) {
            h = mid - 1;
        }
        return bitonicSearchInAscendingArray(arr, l, h, key);
    }

    private static int bitonicSearchInDescendingArray(int[] arr, int l, int h, int key) {
        if (l > h) return -1;
        int mid = (l + h) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            h = mid - 1;
        } else if (arr[mid] > key) {
            l = mid + 1;
        }
        return bitonicSearchInDescendingArray(arr, l, h, key);
    }
}
/*
    Bitonic position element is the greatest element of that array
 */
