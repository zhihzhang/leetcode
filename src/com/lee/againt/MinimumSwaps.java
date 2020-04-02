package com.lee.againt;

public class MinimumSwaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// A = [1,3,5,4], B = [1,2,3,7]

	// A = [1,3,9,7], B = [1,2,4,12];

	public int minSwap(int[] A, int[] B) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		int[][] dp = new int[A.length][2];
		dp[0][0] = 0;
		dp[0][1] = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1] && B[i] > B[i - 1] && !(A[i] > B[i - 1] && B[i] > A[i - 1])) {
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = dp[i - 1][1] + 1;
			} else if (A[i] > B[i - 1] && B[i] > A[i - 1] && !(A[i] > A[i - 1] && B[i] > B[i - 1])) {
				dp[i][0] = dp[i - 1][1];
				dp[i][1] = dp[i - 1][0] + 1;
			} else {
				dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
			}
		}
		return Math.min(dp[A.length - 1][0], dp[A.length - 1][1]);
	}

}
