package com.problems.arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 9,10,11,12,13};
        int[] arr2 = {5, 6, 7, 19, 21, 25};
        // 1,3,5,6,7,8,9,10,11,12,13,19,21,25

        System.out.println(findMedianOfTwoSortedArray(arr1, arr2));
    }

    private static float findMedianOfTwoSortedArray(int[] arr1, int[] arr2) {
        int l = 0;
        int h = 0;
        if (arr2.length > arr1.length) {
            return findMedianOfTwoSortedArray(arr2,arr1);
        } else {
            h = arr1.length;
            int m1 = (l + h) / 2;
            return fidMedianUsingPartitioning(l, h,m1, arr1, arr2);
        }

    }

    private static float fidMedianUsingPartitioning(int l, int h, int m1, int[] arr1, int[] arr2) {
        while (l <= h) {

            int m2 = (arr1.length + arr2.length + 1) / 2 - m1;          // median of 2nd array

            int l1 = m1 == 0 ? Integer.MIN_VALUE : arr1[m1 - 1];           // For median find . we will consider max of l1 and l2
            int r1 = m1 == arr1.length ? Integer.MAX_VALUE : arr1[m1];  // For median find , we will consider min of r1 and r2
            int l2 = m2 == 0 ? Integer.MIN_VALUE : arr2[m2 - 1];
            int r2 = m2 == arr2.length ? Integer.MAX_VALUE : arr2[m2];

            if (l1 <= r2 && l2 <= r1) {
                return findMedian(arr1, arr2, l1, l2, r1, r2);
            } else if (l1 > r2) {
                m1--;        // m1 to left
                h = m1 - 1;
            } else {
                m1++;         // m1 to right
                l = m1 + 1;
            }

        }
        return 0.0f;
    }

    private static float findMedian(int[] arr1, int[] arr2, int l1, int l2, int r1, int r2) {
        if ((arr1.length + arr2.length) % 2 == 0) {              // Always last element of left partition will be greater than all elements in left
            return (float) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        } else {
            return (float)(Math.max(l1, l2));
        }                                                   // For even median is not equally splitted
    }
}
