package com.problems.arrays;

public class SquareRootOfANumber {

    public static void main(String[] args) {
        int n = 28;

        System.out.println(sqrt(n));
    }

    static int sqrt(int n) {
        if(n==0|| n==1){
            return n;
        }
        int l = 2;
        int h = n / 2;  // Factor will occur before the half of that number.
        int res = 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (mid * mid == n) {
                return mid;
            } else if ((mid * mid) < n) {
                l = mid + 1;   // for ceil to return , I am assigning mid to res in this if condition
                res = mid;
            } else {
                h = mid - 1;
            }
        }
        return res;
    }
}
