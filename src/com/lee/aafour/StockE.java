package com.lee.aafour;

public class StockE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] hold = new int[prices.length];
		int[] sell = new int[prices.length];
		hold[0] = -prices[0];
		sell[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			if(i>=2){
				hold[i] = Math.max(hold[i - 1], sell[i - 2] - prices[i]);
			} else {
				hold[i] = Math.max(hold[i - 1], - prices[i]);
			}
			sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
		}
		return sell[prices.length - 1];
	}

}
