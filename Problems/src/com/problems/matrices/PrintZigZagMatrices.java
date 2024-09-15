package com.problems.matrices;

public class PrintZigZagMatrices {
    public static void main(String[] args) {
        int[][] arr= new int[3][3];
        int value=1;
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=value++;
            }
        }

        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("ZIG ZAG");

        for (int i=0;i<arr.length;i++){
            int j=0;
            if(i%2==0){
                for(j=0;j<arr.length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }

           else{
                for(j=arr.length-1;j>=0;j--){
                    System.out.print(arr[i][j]+" ");
                }
            System.out.println();
            }
        }



    }
}
