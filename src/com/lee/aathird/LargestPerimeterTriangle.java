package com.lee.aathird;

import java.util.Arrays;

public class LargestPerimeterTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestPerimeter(int[] A) {
		Arrays.sort(A);
		for (int i = A.length - 1; i - 2 >= 0; i--) {
			if (A[i] < A[i - 1] + A[i - 2]) {
				return A[i] + A[i - 1] + A[i - 2];
			}
		}
		return 0;
	}

}
