package com.problems.matrices;

public class ReverseColumns {
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        reverseColumns(matrix);
    }

    private static void reverseColumns(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            int l=0; int h=matrix[0].length-1;
            while(l<h){
                int temp= matrix[i][l];
                matrix[i][l]=matrix[i][h];
                matrix[i][h]=temp;
                l++;
                h--;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
