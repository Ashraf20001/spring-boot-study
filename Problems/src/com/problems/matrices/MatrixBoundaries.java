package com.problems.matrices;

public class MatrixBoundaries {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21,22,23,24,25}
        };
        printBoundaries(arr);
        System.out.println();
        printBoundariesInAnticlockwise(arr);
    }


    private static void printBoundaries(int[][] arr) {
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            System.out.print(arr[i][j] + " ");
            j++;
        }
        System.out.println();
        j = arr.length - 1;
        i = 1;
        while (i < arr.length) {
            System.out.print(arr[i][j] + " ");
            i++;
        }
        System.out.println();
        i = arr.length - 1;
        j = j - 1;
        while (j >= 0) {
            System.out.print(arr[i][j] + " ");
            j--;
        }
        System.out.println();
        j = 0;
        i = i - 1;
        while (i >= 0) {
            System.out.print(arr[i][j] + " ");
            i--;
        }
        System.out.println();
    }

    private static void printBoundariesInAnticlockwise(int[][] arr) {
        int i = 0;
        int j = arr.length-1;
        while (j >=0) {
            System.out.print(arr[i][j] + " ");
            j--;
        }
        System.out.println();
        j = 0;
        i = 1;
        while (i < arr.length) {
            System.out.print(arr[i][j] + " ");
            i++;
        }
        System.out.println();
        i = arr.length - 1;
        j = 1;
        while (j <arr.length) {
            System.out.print(arr[i][j] + " ");
            j++;
        }
        System.out.println();
        j = arr.length-1;
        i = i - 1;
        while (i >= 0) {
            System.out.print(arr[i][j] + " ");
            i--;
        }
        System.out.println();
    }
}
