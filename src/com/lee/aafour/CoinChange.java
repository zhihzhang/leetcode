package com.lee.aafour;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int c : coins) {
				if (i - c >= 0 && dp[i - c]!=Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - c] + 1);
				}
			}
		}
		int t = dp[amount];
		if(t==Integer.MAX_VALUE){
			return -1;
		}
		return dp[amount];
	}

}
