package com.lee.dp;

import java.util.Arrays;

public class BurstBallons312 {
	public static void main(String[] args) {
		BurstBallons312 obj = new BurstBallons312();
		int[] nums = { 100, 10, 1,1, 10, 100 };
		int result = obj.maxCoins(nums);
		System.out.println(result + "......" + Arrays.toString(nums));
//		if (result != 167) {
//			System.out.println(result + "....." + Arrays.toString(nums));
//		}
	}

	public int maxCoins(int[] nums) {
		int[] temp = new int[nums.length + 2];
		int n = 1;
		for (int x : nums) {
			temp[n++] = x;
		}
		temp[0] = 1;
		temp[nums.length + 1] = 1;

		n = temp.length;
		int[][] dp = new int[n][n];
		for (int k = 2; k < n; k++) {
			for (int left = 0; left + k < n ; left++) {
				int right = left + k;
				for (int i = left + 1; i < right; i++) {
					dp[left][right] = Math.max(dp[left][right],
							temp[left] * temp[i] * temp[right] + dp[left][i] + dp[i][right]);
				}
			}
		}
		return dp[0][n - 1];
	}

}
