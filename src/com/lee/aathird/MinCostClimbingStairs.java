package com.lee.aathird;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	cost = [10, 15, 20] 15
//	cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 6
	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 1) {
			return cost[0];
		}
		if (cost.length == 2) {
			return Math.min(cost[0], cost[1]);
		}
		int[] dp = new int[cost.length + 1];
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
		}
		return dp[dp.length - 1];
	}

}
