package com.problems.matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 38, 39, 40}
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//              {9, 10, 11, 12}
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20}

        };
        System.out.println(spiralOrder(matrix));
    }


    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();

        int top=0; int bottom=matrix.length-1; int left=0; int right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                order.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                order.add(matrix[i][right]);
            }
            right--;

            if(!(top<=bottom && left<=right)){
                break;
            }

            for(int i=right;i>=left;i--){
                order.add(matrix[bottom][i]);
            }
            bottom--;


            for(int i=bottom;i>=top;i--){
                order.add(matrix[i][left]);
            }
            left++;
        }
        return order;
    }
}
