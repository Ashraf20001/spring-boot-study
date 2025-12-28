package com.problems.arrays.greedy_pattern;

public class MinimumGroupFlips {
    public static void main(String[] args) {
        int[] arr={1,0,0,1,1,0,0,0,0,1};
        flipMinimalGroupFlips(arr);
    }

    private static void flipMinimalGroupFlips(int[] arr) {
//        int flipEl= arr[0]==0? 1 : 0;
//        int flipStart=0; int flipEnd=0; int count=0;
//        for (int i=1; i<arr.length;i++){
//            if(arr[i] == flipEl){
//                count++;
//            } else if(count>0){
//                flipEnd=i-1;
//                flipStart=i-count;
//                System.out.println(flipStart+"-"+flipEnd);
//                count=0;
//            }
//        }

        for(int i=0; i<arr.length-1;i++){
            if(arr[i]!=arr[i+1] && arr[i+1]!=arr[0]){
                System.out.print(i+1+"-");
            } else if (arr[i]!=arr[i+1] && arr[i+1]==arr[0]) {
                System.out.print(i);
                System.out.println();
            }

        }
        if(arr[arr.length-1]!=arr[0]){
            System.out.print(arr.length-1);
        }
    }
}
