package com.problems.arrays.searching_binary_search_approach;

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr={2,4,6,7,7,7,7,9};
        int n=8;
        int[]res=findFirstAndLast(arr,n);
        for (int value:res){
            System.out.print(value);
            System.out.print("");
        }
    }

    private static int[] findFirstAndLast(int[] arr,int n) {
            int[] res=new int[2];
            int l=0;
            int h=arr.length-1;
            while(l<=h){
                int m=(l+h)/2;
                if(arr[m]==n){
                   while(m>0 && arr[m-1]==n){
                       m--;
                   }
                   res[0]=m;
                   while(m<arr.length-1 && arr[m+1]==n){
                       m++;
                   }
                   res[1]=m;
                   return res;
                }
                else if(arr[m]<n){
                    l=m+1;
                }
                else{
                    h=m-1;
                }
            }

            res[0]=-1;res[1]=-1;
            return res;
    }
}
