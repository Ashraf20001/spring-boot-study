package com.problems.recursion;

public class PowerOf {
			public static void main(String[] args) {
				System.out.println(powerOf(2,10));
				System.out.println(Math.pow(2, 10));
			}
			
			static int powerOf(int x, int y) {
				if(y==0) {
					return 1;
				}
				
				if(y%2==0) {
//					return powerOf(x,y/2)*powerOf(x,y/2);
					int res = powerOf(x,y/2);
					return res*res;
				}
					return powerOf(x,y-1)*x;
		}
}
