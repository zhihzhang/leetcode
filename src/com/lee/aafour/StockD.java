package com.lee.aafour;

import java.util.Arrays;

public class StockD {
	public static void main(String[] args) {
		StockD obj = new StockD();
		int[] prices = new int[]{2,1,2,0,1};
		int k = 2;
		System.out.println(obj.maxProfit(k, prices));
	}

	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0 || k == 0) {
			return 0;
		}
		int d = prices.length/2 + 1;
		k = Math.min(d, k);
		int[] hold = new int[k];
		int[] sell = new int[k];
		Arrays.fill(hold, Integer.MIN_VALUE);
		Arrays.fill(sell, Integer.MIN_VALUE);
		hold[0] = -prices[0];
		sell[0] = 0;
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int len = (i/2) + 1;
			for (int j = 0; j < k && j < len; j++) {
				int t = 0;
				if (j > 0) {
					t = sell[j - 1];
				}
				sell[j] = Math.max(hold[j] + prices[i], sell[j]);
				max = Math.max(sell[j], max);
				hold[j] = Math.max(hold[j], t - prices[i]);
			}
		}
		return max;
	}
}
