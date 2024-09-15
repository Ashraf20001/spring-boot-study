package com.problems.arrays.tp_approach;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2};
//        int result = identifyTrappedInNaiveApproach(arr);
//        System.out.println(result);

//        System.out.println(identifyTrappedWater1(arr));
        identifyTrappedWater2(arr);
    }

    private static void identifyTrappedWater2(int[] arr) {
        int res=0;
        int lb=arr[0];
        int rb=arr[arr.length-1];
        int l=0;
        int r= arr.length-1;
        while(l<=r){
            if(lb<=rb){
                if(arr[l]>=lb){
                    lb=arr[l];
                }
                else{
                    res=res+ (lb-arr[l]);
                }
                l++;
            }else{
                if(arr[r]>=rb){
                    rb=arr[r];
                }else{
                    res=res+(rb-arr[r]);
                }
                r--;
            }
        }
        System.out.println(res);
    }


    private static int identifyTrappedWater1(int[] arr) {

        if(arr.length<3){
            return 0;
        }

        int res=0;

        int[] lb= new int[arr.length];
        int[] rb = new int[arr.length];
        lb[0]=arr[0];rb[arr.length-1]=arr[arr.length-1];

        for (int i = 1; i < arr.length; i++) {
           lb[i]=Math.max(arr[i],lb[i-1]);
        }

        for(int i=arr.length-2;i>=0;i--){
           rb[i]=Math.max(arr[i],rb[i+1]);
        }

        for (int i=1; i< arr.length-1; i++){
            int lb_el=lb[i];
            int rb_el=rb[i];
            int lvl= Math.min(lb_el,rb_el);
            int tw= Math.max(lvl - arr[i], 0);
            res+=tw;

        }

        return res;
    }

    private static int identifyTrappedInNaiveApproach(int[] arr) {
        if(arr.length<3){
            return 0;
        }

       int res=0;
       for(int i=1; i<arr.length-1;i++){
           int lb=arr[i];
           for(int j=0;j<i;j++){
               if(arr[j]>lb){
                   lb=arr[j];
               }
           }
           int rb=arr[i];
           for(int k=i+1;k<arr.length;k++){
               if(arr[k]>rb) {
                   rb = arr[k];
               }
           }
           int wl=Math.min(lb,rb);
           int tw= Math.max(wl - arr[i], 0);
           res+=tw;

       }
       return res;
    }
}
