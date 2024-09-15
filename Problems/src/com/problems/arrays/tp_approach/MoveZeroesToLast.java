package com.problems.arrays.tp_approach;

// Two pointer approach

public class MoveZeroesToLast {
    public static void main(String[] args) {
        int[] arr={1,0,1,3,0};
        moveZeroToEnd(arr);   // nz=3, z=2, 1 3 12 0 0
        for (int a: arr){
            System.out.print(a+" ");
        }
    }

    private static void moveZeroToEnd(int[] arr) {

       if(arr.length==1){
           return;
       }
       int z=0;
       for (int nz=0; nz<arr.length; nz++){
           if(arr[nz]!=0){
               int temp=arr[z];
               arr[z]=arr[nz];
               arr[nz]=temp;
               z++;
           }
       }
    }
}
