package com.problems.matrices;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] matrix={
                {1,6,11,16,21},
                {2,7,12,17,22},
                {3,8,13,18,23},
                {4,9,14,19,24}
//                {5,10,15,20,25}
        };
        printTranspose(matrix);
    }

    private static void printTranspose(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length && j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;

            }
        }

        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
