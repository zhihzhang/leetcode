package com.lee.aafour;

public class StockF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices, int fee) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int sell = 0;
		int hold = -prices[0];
		for (int i = 0; i < prices.length; i++) {
			int t = sell;
			sell = Math.max(sell, hold + prices[i] - fee);
			hold = Math.max(t - prices[i], hold);
		}
		return sell;
	}

}
