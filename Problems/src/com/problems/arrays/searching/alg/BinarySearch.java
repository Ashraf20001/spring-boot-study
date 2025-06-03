package com.problems.arrays.searching.alg;


// Best for sorted arrays
public class BinarySearch {
		public static void main(String[] args) {
			int k=20;
			int[] arr = {2, 10, 14, 20};
			int position = binarySearch(arr, 0,arr.length-1,k);
			System.out.println("position is "+position);
		}

	private static int binarySearch(int[] arr, int k) {
			int f=0;
			int l=arr.length-1;
			while(f<=l){
				int mid= (f+l)/2;
				if(arr[mid]==k){
					return mid;
				}
				else if(arr[mid]<k){
					f=mid+1;
				}
				else{
					l=mid-1;
				}
			}
			return -1;
	}

	// recursive approach
	private static int binarySearch(int[] arr,int l,int h,int k){
			if(l<=h){
				int m = (l+h)/2;
				if(arr[m] == k){
					return m;
				}
				else if(arr[m]<k){
					return binarySearch(arr,m+1,h,k);
				}else{
					return binarySearch(arr,l,m-1,k);
				}
			}
			return -1;
	}
}
