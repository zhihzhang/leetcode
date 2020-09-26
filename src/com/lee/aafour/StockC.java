package com.lee.aafour;

public class StockC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	[3,3,5,0,0,3,1,4] 6
//	[1,2,3,4,5] 4
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int hold1 = -prices[0];
		int sell1 = 0;
		int hold2 = Integer.MIN_VALUE;
		int sell2 = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			int t = sell1;
			sell1 = Math.max(hold1 + prices[i], sell1);
			hold1 = Math.max(hold1, -prices[i]);
			sell2 = Math.max(hold2 + prices[i], sell2);
			hold2 = Math.max(t - prices[i], hold2);
		}
		return Math.max(sell1, sell2);
	}

}
