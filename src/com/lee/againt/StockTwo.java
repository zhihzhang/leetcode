package com.lee.againt;

public class StockTwo {

	public static void main(String[] args) {
		StockTwo obj = new StockTwo();
		System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));

	}

	//[7,1,5,3,6,4]
	//[1,2,3,4,5]
	//[7,6,4,3,1]
	public int maxProfit(int[] prices) {
		int sum = 0;
		int max = 0;
		int l = 0;
		int r = 1;
		while (r < prices.length) {
			while (r < prices.length) {
				int t = prices[r] - prices[l];
				if (t >= max) {
					max = t;
					r++; 
				} else {
					l = r;
					r = l + 1;
					break;
				}
			}
			sum += max;
			max = 0;
		}
		return sum;
	}

}
