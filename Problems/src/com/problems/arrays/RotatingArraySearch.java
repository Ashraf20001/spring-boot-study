package com.problems.arrays;

public class RotatingArraySearch {

    public static void main(String[] args) {
        int[] arr={3,1};
        int target=1;
        System.out.println(rotatingArraySearch(arr,target));
    }

    private static int rotatingArraySearch(int[] arr, int target) {
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[l]==arr[mid]){
                l++;
            }
            else if(arr[l]<arr[mid]){
                if(target>=arr[l] && target<arr[mid]){
                    h=mid-1;
                }
                else {
                    l=mid+1;
                }
            }else{
                if(target>arr[mid] && target<=arr[h]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }

        return -1;

    }
}
