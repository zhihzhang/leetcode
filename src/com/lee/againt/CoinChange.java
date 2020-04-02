package com.lee.againt;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// coins = [1, 2, 5], amount = 11 3
	//
	// coins = [2], amount = 3 -1

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		Arrays.fill(dp, -1);
		for (int i = 1; i <= amount; i++) {
			for (int c : coins) {
				if (i - c < 0) {
					continue;
				} else if (i == c) {
					dp[i] = 1;
				} else {
					if (dp[i - c] != -1) {
						if (dp[i] == -1) {
							dp[i] = dp[i - c] + 1;
						} else {
							dp[i] = Math.min(dp[i], dp[i - c] + 1);
						}
					}
				}
			}
		}
		return dp[amount];
	}

}
