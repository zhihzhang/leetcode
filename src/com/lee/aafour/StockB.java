package com.lee.aafour;

public class StockB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//[7,1,5,3,6,4]
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int hold = -prices[0];
		int sold = 0;
		for (int i = 1; i < prices.length; i++) {
			int t = hold;
			hold = Math.max(sold - prices[i], hold);
			sold = Math.max(prices[i] + t, sold);
		}
		return sold;
	}

}
