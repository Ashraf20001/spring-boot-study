package com.problems.arrays.searching.alg;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = { 8, 3, 1, 10, 5 };
		int key = 90;
		System.out.println(linearSearch(arr, key));
	}

	private static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				return i+1;
			}
		}

		return -1;
	}
}
