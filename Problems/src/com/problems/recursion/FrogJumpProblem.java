package com.problems.recursion;

import java.util.Arrays;

public class FrogJumpProblem {
    public static void main(String[] args) {
        int steps = 5;
        int[] memoizationArray = new int[steps+1];

        Arrays.fill(memoizationArray, -1);

//        System.out.println(findPossibleWays(steps,memoizationArray));
        System.out.println(findPossibleWaysInTopDownApproach(steps,memoizationArray));
    }

    private static int findPossibleWays(int steps, int[] memoizationArray) {
        if( memoizationArray[steps]==-1){
            if(steps <= 1){
                 memoizationArray[steps]=1;
            }else{
                memoizationArray[steps] = findPossibleWays(steps-1,memoizationArray)+ findPossibleWays(steps-2,memoizationArray);
            }
        }
        return memoizationArray[steps];
    }

    private static int findPossibleWaysInTopDownApproach(int steps,int[] memoizationArray){
        memoizationArray[0]=1;
        memoizationArray[1]=1;
        for(int i = 2 ; i<=steps ; i++){
            memoizationArray[i]=memoizationArray[i-1]+memoizationArray[i-2];
        }

        return memoizationArray[steps];
    }
}
