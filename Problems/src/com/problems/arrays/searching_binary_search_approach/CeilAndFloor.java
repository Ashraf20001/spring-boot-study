package com.problems.arrays.searching_binary_search_approach;

public class CeilAndFloor {
    public static void main(String[] args) {
        int[] arr = {19, 23, 56, 61, 72, 88, 92};
        System.out.println(ceil(arr, 108));
        System.out.println(floor(arr, 68));
    }

    private static int ceil(int[] arr, int i) {
        int l = 0;
        int h = arr.length - 1;
        Integer ceilValue = binarySearchMethod(arr, i, l, h, true);
        if (ceilValue != null) return ceilValue;
        return -1;
    }

    private static int floor(int[] arr, int i) {
        int l = 0;
        int h = arr.length - 1;
        Integer floorValue = binarySearchMethod(arr, i, l, h, false);
        if (floorValue != null) return floorValue;
        return -1;
    }

    private static Integer binarySearchMethod(int[] arr, int i, int l, int h, boolean isCeil) {
        while (l <= h) {

            int mid = (l + h) / 2;
            if (arr[mid] == i) {
                return arr[mid];
            } else if (arr[mid] > i) {
                h = mid - 1;
            } else if (arr[mid] < i) {
                l = mid + 1;
            }

        }
        if (isCeil) {
            if (l > i) {
                return arr[l];
            }
        } else {
            if (h < i) {
                return arr[h];
            }
        }
        return null;
    }


}
