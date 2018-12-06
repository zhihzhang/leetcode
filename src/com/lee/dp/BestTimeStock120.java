package com.lee.dp;

public class BestTimeStock120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = 1; j < prices.length; j++) {
				max = Math.max(prices[j] - prices[i], max);
			}
		}
		
		return max;
	}

}
