package com.problems.matrices;

public class MatrixTargetSearch {
    public static void main(String[] args) {
        int[][] arr ={
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24}
        };

        int target=6;

        System.out.println(isTargetPresentInMatrices(arr, target));
    }

    private static boolean isTargetPresentInMatrices(int[][] arr, int target) {


//        for (int i = 0; i < arr.length; i++) {
//           int l= 0; int h= arr[i].length-1;
//
//           while(l<=h){
//               int mid=(l+h)/2;
//               if(arr[i][mid]== target){
//                   return true;
//               }
//               else if(arr[i][mid]<target){
//                   l=mid+1;
//               }
//               else {
//                   h=mid-1;
//               }
//           }
//        }

        int l=0;int h=arr[0].length-1;
        while(l<arr.length && h >=0){
            if(arr[l][h]==target){
                return true;
            }
            else if(arr[l][h]>target){
                h--;
            } else{
                l++;
            }
        }
        return false;
    }
}

/*
    In order to find an element in a matrix which is sorted, pick two pointers at "first row" namely l and h.
    l is the row pointing at 0th position and h is the column pointing at last element of that row.
    Continue checking whether arr[l][h] th element is lesser than the target element.
    Before that if that arr[l][h] th element is equal to the target element then return true.
    If it is not, then by checking the arr[l][h] is lesser than the target element and if it so, then decrement the lth value which means
    we are shifting to another row of same column.
    If it is greater then, decrement h value which means reducing the current column value .

    By continuing these operations we are thoroughly moving through entire matrix and checking for the target in efficient manner.
 */