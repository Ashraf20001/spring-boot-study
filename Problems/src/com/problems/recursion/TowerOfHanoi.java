package com.problems.recursion;

public class TowerOfHanoi {
			public static void main(String[] args) {
				towerOfHanoiMoves(3,'A', 'B', 'C');
			}
			
			static void towerOfHanoiMoves(int n,char src, char aux, char des) {
				if(n==1) {
					System.out.println(src+" -> "+des);
					return;
				}
				towerOfHanoiMoves(n-1,src,des, aux);  // move two discs from a to b
				towerOfHanoiMoves(1,src,aux, des);    // move one disc from a to c
				towerOfHanoiMoves(n-1,aux, src, des);  // move two discs from b to c
			}
}