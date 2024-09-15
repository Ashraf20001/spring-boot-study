package com.problems.arrays;

public class LeadersOfAnArray {
    // Leader element is greater than all other elements at right side and right most element is always a leader

    public static void main(String[] args) {
        int[] arr={1,17,30,20,4,7,8};
//        inefficientApproachToCalculateLeaders(arr);
            efficientApproachToCalculateLeaders(arr);
    }

    private static void efficientApproachToCalculateLeaders(int[] arr) {
            int cur_leader=arr[arr.length-1];
            for (int i = arr.length-2; i>=0; i--) {
                if (arr[i] > cur_leader) {
                    cur_leader=arr[i];
                    System.out.print(cur_leader+" ");
                }
            }

    }

    private static void inefficientApproachToCalculateLeaders(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean is_Leader=true;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]>=arr[i]) {
                    is_Leader = false;
                    break;
                }
            }
            if(is_Leader){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
