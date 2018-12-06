package com.lee.math;

public class RotateFunction396 {

	public static void main(String[] args) {
		RotateFunction396 obj = new RotateFunction396();
		System.out.println(9%7);
	}
	
	public int maxRotateFunction(int[] A) {
		int l = A.length;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < l; i++) {
			long sum = 0;
			int f = 0;
			for (int k = i; k < l + i; k++) {
				sum = sum + A[k % l] * f;
				f++;
			}
			max = Math.max(sum, max);
		}
		return (int)max;
	}

}
