package com.problems.arrays.tp_approach;

// Two pointer approach
public class RemoveDuplicatesInSortedArray {
    public static void main(String[] args) {
        int[] arr={2,2,3,3,4,4};
        removeDuplicates(arr);
    }

    private static void removeDuplicates(int[] arr) {
        int rd=0;
        for(int i=1; i<arr.length ; i++){
            if(arr[rd]!=arr[i]){
                rd++;
                arr[rd]=arr[i];
            }
        }
        for (int i=0; i<=rd ; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
