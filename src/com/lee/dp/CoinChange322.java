package com.lee.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoinChange322 {

	public static void main(String[] args) {
		CoinChange322 obj = new CoinChange322();
		System.out.println(obj.coinChange(new int[] { 1, 2, 5 }, 18));
		System.out.println(obj.coinChange(new int[] { 1, 2147483647 }, 2));
	}

	public int coinChange(int[] coins, int amount) {
//		Arrays.sort(coins);
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				continue;
			}
			for (int c : coins) {
				if ((long) i + (long) c > (long) amount) {
					continue;
				}
				dp[i + c] = Math.min(dp[i] + 1, dp[i + c]);
			}
		}
		if (dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[amount];
	}

	// public int coinChange(int[] coins, int amount) {
	// Arrays.sort(coins);
	//
	// int[] dp = new int[amount + 1];
	// Arrays.fill(dp, Integer.MAX_VALUE);
	// dp[0] = 0;
	// PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
	// queue.offer(0);
	// while (!queue.isEmpty()) {
	// int t = queue.poll();
	// for (int c : coins) {
	// if ((long)t + (long)c > (long)amount) {
	// break;
	// }
	// dp[t + c] = Math.min(dp[t] + 1, dp[t + c]);
	// queue.offer(t + c);
	// }
	// }
	// if (dp[amount] == Integer.MAX_VALUE) {
	// return -1;
	// }
	// return dp[amount];
	// }

}
