package com.lee.again;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minFallingPathSum(int[][] A) {
		int[][] dp = new int[A.length][A[0].length];
		for (int i = 0; i < A[0].length; i++) {
			dp[0][i] = A[0][i];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				int t = Integer.MAX_VALUE;
				if (j - 1 >= 0) {
					t = Math.min(dp[i - 1][j - 1], t);
				}
				t = Math.min(dp[i - 1][j], t);
				if (j + 1 < A[0].length + 1) {
					t = Math.min(dp[i - 1][j + 1], t);
				}
				dp[i][j] = A[i][j] + t;
				if (i == A.length - 1) {
					min = Math.min(min, dp[i][j]);
				}
			}
		}
		return min;
	}

}
