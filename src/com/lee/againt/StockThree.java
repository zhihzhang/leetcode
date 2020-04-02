package com.lee.againt;

public class StockThree {

	public static void main(String[] args) {
		StockThree obj = new StockThree();
//		System.out.println(obj.maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
		System.out.println(obj.maxProfit(new int[] { 1, 4, 2, 6, 14, 5, 6, 15, 0 }));

	}

	public int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}

}
