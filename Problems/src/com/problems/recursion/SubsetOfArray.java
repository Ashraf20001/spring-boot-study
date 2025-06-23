package com.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetOfArray {
		
		public static void main(String[] args) {
			int[] arr=	new int[] {10,20,15,5};
			int sum=40;
			
			System.out.println(getPossibleSubsets(arr, sum,0));
//			ArrayList<ArrayList<Integer>> allPossibleSubsets = getAllPossibleSubsets(arr);
//			for (ArrayList<Integer> subsets : allPossibleSubsets){
//				System.out.println(subsets);
//			}
		}
		
		static int getPossibleSubsets(int[] arr, int sum, int i) {
			if(sum==0) {
				return 1;
			}
			else if(sum<0) {
				return 0;
			}
			else if(i==arr.length) {
				return 0;
			}
			
			int res1= getPossibleSubsets(arr, sum-arr[i], i+1);  // pick an element and contribute it for sum
			int res2= getPossibleSubsets(arr, sum, i+1);         // not pick an element and no contribution for sum
																 // incrementation is same for both cases			
			return res1+res2;
		}

		public static ArrayList<ArrayList<Integer>> getAllPossibleSubsets(int[] arr){
			Arrays.sort(arr);
			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			ArrayList<Integer> subset = new ArrayList<>();
			subsetRecur(arr,0,res,subset);
			res.sort((a,b)->{   // Lexicographical sorting
				int min = Math.min(a.size(),b.size());
				for(int i=0;i<min;i++){
					 int cmp = Integer.compare(a.get(i),b.get(i));
					 if(cmp!=0){
						 return cmp;
					 }
				}
				return Integer.compare(a.size(),b.size());
			});
			return res;
		}

	private static void subsetRecur(int[] arr, int i, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset) {
		if (i==arr.length){
			res.add(new ArrayList<>(subset));
			return;
		}

		subset.add(arr[i]);
		subsetRecur(arr,i+1,res,subset);

		subset.remove(subset.size()-1);
		subsetRecur(arr,i+1,res,subset);
	}
}
