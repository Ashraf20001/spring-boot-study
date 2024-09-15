package com.problems.matrices;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        rotateImage(matrix);

        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateImage(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j< matrix.length && i< matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int i=0;i<matrix.length;i++){
            int l=0; int h=matrix[0].length-1;
            while(l<h){
//                int temp=matrix[i][l];
//                matrix[i][l]=matrix[i][h];
//                matrix[i][h]=temp;

                matrix[i][l]=matrix[i][l] ^ matrix[i][h];       // a= a ^ b
               matrix[i][h]= matrix[i][l] ^ matrix[i][h];       // b= a ^ b
               matrix[i][l]=matrix[i][l] ^ matrix[i][h];        // a= a ^ b
                l++;
                h--;
            }
        }
    }

}
