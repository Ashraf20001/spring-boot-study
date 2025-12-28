package com.problems.arrays.searching_binary_search_approach;

public class PainterPartition {
	
	public static void main(String[] args) {
		int[] arr= {5,10,3,6};   // paint boards length
		int p= 2;
		int t = 2;
		System.out.println(findPaintTime(arr,p,t));
	}

	private static int findPaintTime(int[] arr, int p, int t) {
		
		if(p>arr.length) {
			return -1;
		}
		
		int res=0;
		int l=0;
		int h = AllocateBooks.findSum(arr) *t;
		while(l<=h) {
			int mid = (l+h)/2;                             //   h =1, l=6
			if(isPossiblePainting(arr,mid,p)) {
				res=mid;
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		
		return res;
	}

	private static boolean isPossiblePainting(int[]arr,int mid, int p) {
		int painter=1;
		int boardForPainter=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>mid) {
				return false;
			}
			
			if(boardForPainter+arr[i]<=mid) {
				boardForPainter+=arr[i];
			}
			else {
				painter++;
				if(painter>p) {
					return false;
				}
				boardForPainter=arr[i];
			}
		}
		return true;
	}
	

}
