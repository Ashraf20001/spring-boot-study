package com.problems.arrays.searching_binary_search_approach;

public class WoodCuttingProblem {
    public static void main(String[] args) {
        int[] arr={20,15,10,17};
        int b=8;
        System.out.println(sawHeight(arr,b));
    }

    private static int sawHeight(int[] arr, int b) {
        int max=findMaxNumber(arr);
        int l=0;
        while(l<=max){
            int wc=0;
            int mid=(l+max)/2;
            wc = cutWood(arr, wc, mid);
            if(wc==b ||
            l==mid){
                return mid;
            }
            else if(wc>b){
                l=mid;
            }
            else{
                max=mid;
            }
        }
        return -1;
    }

    private static int cutWood(int[] arr, int wc, int mid) {
        for(int ar: arr){
            wc += Math.max((ar - mid), 0);
        }
        return wc;
    }

    private static int findMaxNumber(int[] arr) {
        int max=0;
        for(int val:arr){
            if(val>max){
                max=val;
            }
        }
        return max;
    }

}
