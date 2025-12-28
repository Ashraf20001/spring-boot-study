package com.problems.arrays.searching_binary_search_approach;

public class AllocateBooks {
	
		public static void main(String[] args) {
				int[] booksPageNumbers= {12,34,67,90};
				int students=2;
				System.out.println(findPageNumbers(students,booksPageNumbers));
		}

		private static int findPageNumbers(int students, int[] booksPageNumbers) {
			int res=0;
			if (students>booksPageNumbers.length) {
				return -1;
			}
			int low=findMax(booksPageNumbers);
			int high=findSum(booksPageNumbers); 
			while(low<=high) {
				int mid= (low+high)/2;
				if(isPossiblePagesAllocated(mid,booksPageNumbers,students)) {
					res=mid;
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
			return res;
		}

		private static boolean isPossiblePagesAllocated(int mid, int[] booksPageNumbers, int students) {
			int allocatedStudents=1;
			int scp = 0;
			
			
			for (int i = 0; i < booksPageNumbers.length; i++) {
				
				if(booksPageNumbers[i]>mid) {
					return false;
				}
				
				if(scp+booksPageNumbers[i]<=mid) {
					scp+=booksPageNumbers[i];
				}
				else {
					allocatedStudents++;
					if(allocatedStudents>students) {
						return false;
					}
					scp=booksPageNumbers[i];
				}
			}
			return true;
		}

		public static int findSum(int[] booksPageNumbers) {
			int sum=0;
			for (int i : booksPageNumbers) {
				sum+=i;
			}
			return sum;
		}

		public static int findMax(int[] booksPageNumbers) {
			int max=0;
			for(int el:booksPageNumbers) {
				if(el>max) {
					max=el;
				}
			}
			return max;
		}

}
