package com.problems.arrays.searching_binary_search_approach;

public class CountNumberLessThanOrEqual {
    public static void main(String[] args) {
        int[] arr = {2, 6,8, 12, 21, 26};
        int key = 25;
        System.out.println(countOfSmallAndEqualElements(arr, key));
    }

    private static int countOfSmallAndEqualElements(int[] arr, int key) {
        return binarySearchForGettingLessThanEqual(arr, key);
    }

    private static int binarySearchForGettingLessThanEqual(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        int m = 0;
        while (l <= h) {
            m = (l + h) / 2;
            if (arr[m] == key) {
                while (m < arr.length - 1 && arr[m + 1] == key) {
                    m++;
                }
                return m + 1;
            } else if (arr[m] < key) {
                l = m + 1;
            } else if (arr[m] > key) {
                h = m - 1;
            }
        }
        if (arr[m] > key) {
            return m;
        } else {
            return m + 1;
        }
    }


}
