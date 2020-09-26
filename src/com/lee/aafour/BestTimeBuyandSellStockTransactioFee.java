package com.lee.aafour;

public class BestTimeBuyandSellStockTransactioFee {

	public static void main(String[] args) {
		BestTimeBuyandSellStockTransactioFee obj = new BestTimeBuyandSellStockTransactioFee();
		int[] prices = new int[] { 1, 3, 2, 8, 4, 9 };
		int fee = 2;
		System.out.println(obj.maxProfit(prices, fee));

	}

	// [1,3,2,8,4,9]
	// 2
	public int maxProfit(int[] prices, int fee) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int n : prices) {
			if (n < min) {
				min = n;
			} else if (n > max) {
				max = n;
			}
		}
		return sum;
	}

}
