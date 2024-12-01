package com.problems.arrays;

public class RotateArrayToLeft {

    public static void main(String[] args) {
            int [] arr ={-1,-100,3,99};  // {4,3,2,6,5} // {5,6,2,3,4}
            int k=2;

            rotateArray(arr,k);
            for (int el:arr){
            System.out.print(el);
            System.out.print(" ");
            }
            // If rotate to right means, change k value to negative
    }

    public static void rotateArray(int[] arr, int k) {

            k=k%arr.length;
            if(k<0){
                k=k+arr.length;
            }

            // Worst condition
            if(k%arr.length==0){
                return;
            }

            int l=0; int h=k-1;
            reverseArray(arr,l,h);
            l=k;h=arr.length-1;
            reverseArray(arr,l,h);
            l=0; h=arr.length-1;
            reverseArray(arr,l,h);

    }

    private static void reverseArray(int[] arr, int l, int h) {
        while(l<=h){
            int temp=arr[l];
            arr[l]=arr[h];
            arr[h]=temp;
            l++;
            h--;
        }
    }
}
