package com.lee.aathird;

public class PredictWinner {

	public static void main(String[] args) {
		PredictWinner obj = new PredictWinner();
		System.out.println(obj.PredictTheWinner(new int[]{1,5,2}));
	}
	
	//[1, 5, 2]
	//[1, 5, 233, 7]
	public boolean PredictTheWinner(int[] nums) {
		int l = nums.length;
		if (l < 3) {
			return true;
		}
		int[][] dp = new int[l][l];
		for (int i = 0; i < l - 1; i++) {
			dp[i][i + 1] = Math.abs(nums[i] - nums[i + 1]);
		}
		for (int j = 2; j < l; j++) {
			for (int i = 0; i + j < l; i++) {
				dp[i][i + j] = Math.max(nums[i] - dp[i + 1][i + j], nums[i + j] - dp[i][i + j - 1]);
			}
		}
		return (dp[0][l-1]>=0);
	}

}
