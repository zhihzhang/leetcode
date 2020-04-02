package com.lee.againt;

import java.util.Arrays;

public class CoinChange2 {

	public static void main(String[] args) {
		CoinChange2 obj = new CoinChange2();
		int[] coins = new int[]{1, 2, 5};
		int amount = 5;
		System.out.println(obj.change(5, coins));
	}

	public int change(int amount, int[] coins) {
		if (amount == 0 || coins == null || coins.length == 0) {
			return 0;
		}
		int[] memo = new int[amount + 1];
		Arrays.fill(memo, -1);
		Arrays.sort(coins);
		return change(amount, coins, memo);
	}

	public int change(int amount, int[] coins, int[] memo) {
		if (amount < 0) {
			return 0;
		}
		if (amount == 0) {
			return 1;
		}
		if (memo[amount] > -1) {
			return memo[amount];
		}
		int count = 0;
		for (int c : coins) {
			count += change(amount - c, coins, memo);
		}
		memo[amount] = count;
		return count;
	}

}
