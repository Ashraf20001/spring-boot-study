package com.problems.recursion;

public class RopeCuttingProblem {
	public static void main(String[] args) {
		int n = 15;
		int a = 5, b = 7, c = 8;
		int pieces = possiblePieces(n, a, b, c);
		System.out.println(pieces);
	}

	static int possiblePieces(int n, int a, int b, int c) {
		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return -1;
		}
		int temp1 = possiblePieces(n - a, a, b, c);
		int temp2 = possiblePieces(n - b, a, b, c);
		int temp3 = possiblePieces(n - c, a, b, c);
		int res = Math.max(temp1, Math.max(temp2, temp3));
		if (res == -1) {
			return -1;
		}

		return res + 1;
	}

}
