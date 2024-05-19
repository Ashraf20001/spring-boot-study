package com.problems.arrays;

public class SecondLargestNumber {

    public static void main(String[] args) {
        int[] arr = {4,3,6,0,2};
        int secondLargest = secondLargest(arr);
        System.out.println(secondLargest);
    }

    private static int secondLargest(int[] arr) {
        int max1=Integer.MIN_VALUE+1;
        int max2=Integer.MIN_VALUE;

        for(int i=0; i<arr.length;i++){
            if(arr[i]>max1){
                max2=max1;
                max1=arr[i];
            }
            else if(arr[i]>max2 && arr[i]!=max1){
                max2=arr[i];
            }
        }
        return max2;
    }
}
