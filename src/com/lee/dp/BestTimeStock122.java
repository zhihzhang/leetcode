package com.lee.dp;

public class BestTimeStock122 {
	public static void main(String[] args) {
		BestTimeStock122 obj = new BestTimeStock122();
		 System.out.println(obj.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(obj.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		 System.out.println(obj.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public int maxProfit(int[] prices) {
		int max = 0;
		int i = 0;
		int j = 0;

		while (true) {
			if (i >= prices.length - 1) {
				break;
			}
			if (prices[i] > prices[i + 1]) {
				i++;
				continue;
			}
			j = i + 1;
			if (j == prices.length - 1) {
				int t = prices[j] - prices[i];
				if (t > 0) {
					max += t;
				}
				break;
			} else {
				while (j <= prices.length - 1) {
					if (j == prices.length - 1) {
						max += prices[j] - prices[i];
						i = j + 1;
						break;
					} else if (prices[j] < prices[j + 1]) {
						j++;
					} else {
						max += prices[j] - prices[i];
						i = j + 1;
						break;
					}
				}
			}
		}
		return max;
	}
}
