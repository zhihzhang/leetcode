package com.lee.again;

import java.util.Arrays;

public class CoinChange2 {
	public static void main(String[] args) {
		CoinChange2 obj = new CoinChange2();
		System.out.println(obj.change(10, new int[] { 1,3,5}));

	}

	int count = 0;

	public int change(int amount, int[] coins) {
		Arrays.sort(coins);
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int c : coins) {
			for (int i = 1; i <= amount; i++) {
				if (i - c > -1) {
					dp[i] = dp[i-c] + dp[i];
				}
			}
		}
		return dp[amount];
	}

	public int change123(int amount, int[] coins) {
		Arrays.sort(coins);
		backtrace(amount, coins, 0);
		return count;
		// int[] dp = new int[amount + 1];
		// dp[0] = 1;
		// for (int i = 0; i <= amount; i++) {
		// for (int c : coins) {
		// if (i + c <= amount) {
		// dp[i + c] = dp[i + c] + dp[i];
		// }
		// }
		// }
		// return dp[amount];
	}

	public void backtrace(int a, int[] coins, int i) {
		if (a == 0) {
			count++;
			return;
		}
		while (i < coins.length) {
			int c = coins[i];
			if (c > a) {
				return;
			} else {
				backtrace(a - c, coins, i);
			}
			i++;
		}
	}

}
