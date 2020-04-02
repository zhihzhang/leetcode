package com.lee.againt;

public class StockOne {

	public static void main(String[] args) {

	}
	
//	[7,1,5,3,6,4]
//	[7,6,4,3,1]
	public int maxProfit(int[] prices) {
		int max = 0;
		int v = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			int t = prices[i];
			v = Math.max(max - t, v);
			max = Math.max(max, t);
		}
		return v;
	}

}
