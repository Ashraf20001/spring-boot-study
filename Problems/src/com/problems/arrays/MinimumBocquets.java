package com.problems.arrays;

public class MinimumBocquets {

    public static void main(String[] args) {
       int[] arr={1,10,3,10,2};
        System.out.println(minDays(arr,3,1));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;
        }
        int l=bloomDay[0];
        int h=bloomDay[0];
        int res=-1;
        for(int bloom: bloomDay){
            if(bloom<l){
                l=bloom;
            }
            if(bloom>h){
                h=bloom;
            }
        }

        while(l<=h){
            int mid=(l+h)/2;
            if(isPossibleToMakeBocquets(mid,bloomDay,m,k)){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }

   private static boolean isPossibleToMakeBocquets(int mid, int []bloomDay, int m, int k){
        int b=0; int f=k;
        for(int bloom: bloomDay){
            if(bloom<=mid){
                f--;
                if(f==0){
                    b++;
                    if(b==m){
                        return true;
                    }
                    f=k;
                }
            }
            else {
                f=k;
            }
        }

        return false;
    }
}
