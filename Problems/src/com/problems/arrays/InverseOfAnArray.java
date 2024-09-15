package com.problems.arrays;

public class InverseOfAnArray {
    public static void main(String[] args) {
        int[] a={2,3,1,0,4};
        int [] b= new int[a.length];
        inverseOfAnArray(a,b);
        for (int belement : b){
            System.out.print(belement+" ");
        }
    }

    private static void inverseOfAnArray(int[] a,int[] b) {
        for(int i=0; i <a.length ; i++){
            int v=a[i];
            b[v]=i;
        }
    }
}
