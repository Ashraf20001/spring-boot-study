package com.problems.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "epzupkr";
        String text2 = "ubmrapg";

//        int length = lengthOfCommonSubsequence(text1,text2);
        int length2 = bottomUpApproach(text1,text2);
        System.out.println(length2);
    }

    private static int lengthOfCommonSubsequence(String text1, String text2) {
       int[][] memo = new int[text1.length() + 1][text2.length()+1];

        for (int i = 0; i <=text1.length(); i++) {
            Arrays.fill(memo[i],-1);
        }
       return dpMemoizationApproach(text1,text2,text1.length(),text2.length(),memo);
    }

    private static int dpMemoizationApproach(String text1, String text2, int m, int n, int[][] memo) {
        if(m==0 || n ==0){
            return 0;
        }

        if(memo[m][n] != -1){
            return  memo[m][n];
        }

        if(text1.charAt(m-1) == text2.charAt(n-1)){
            return memo[m][n] = 1 + dpMemoizationApproach(text1,text2,m-1,n-1,memo);
        }
        return memo[m][n] = Math.max(dpMemoizationApproach(text1,text2,m,n-1,memo),dpMemoizationApproach(text1,text2,m-1,n,memo));
    }

    private static  int bottomUpApproach(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] dpTable = new int[m+1][n+1];
        StringBuilder subSequence = new StringBuilder();
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dpTable[i][j] = 1 + dpTable[i-1][j-1];
                    subSequence.append(text1.charAt(i-1));
                }else{
                    dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i][j-1]);
                }
            }
        }
        System.out.println(new String(subSequence).substring(0,dpTable[m][n]));
        return dpTable[m][n];
    }
}

