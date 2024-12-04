package com.problems.java;

public class Pattern {

    public static void main(String[] args) {
        int x = 7;
//        printInvertedPyramid(x);

        printPyramidStar(x);

    }

    private static void printPyramidStar(int x) {
        for (int i = 1; i <=x; i++) {
            for (int j =1; j <= x-i ; j++) {
                System.out.print(" ");
            }

            for (int k=1 ; k <= (2 * i) - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printInvertedPyramid(int x) {
        for (int i = 1; i <=x; i++) {
           int j =1;
            while(j <= (2*x) -i){
                if(j<i){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
                j++;
            }

            System.out.println();
        }
    }
}
