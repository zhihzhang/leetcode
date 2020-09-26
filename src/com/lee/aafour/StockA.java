package com.lee.aafour;

public class StockA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	[7,1,5,3,6,4]
	public int maxProfit(int[] prices) {
		if(prices.length==0){
			return 0;
		}
		int hold = -prices[0];
		int sold = 0;
		for (int i = 1; i < prices.length; i++) {
			sold = Math.max(sold, prices[i] + hold);
			hold = Math.max(hold, -prices[i]);
		}
		return sold;
	}

}
