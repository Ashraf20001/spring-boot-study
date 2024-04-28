package com.problems.arrays;


// Best for sorted arrays
public class BinarySearch {
		public static void main(String[] args) {
			int k=15;
			int[] arr = {2, 10, 14, 20};
			int position = binarySearch(arr, k);
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
}
