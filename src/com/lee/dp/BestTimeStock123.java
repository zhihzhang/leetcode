package com.lee.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestTimeStock123 {
	public static void main(String[] args) {
		BestTimeStock123 obj = new BestTimeStock123();
//		System.out.println(obj.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
//		System.out.println(obj.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
//		System.out.println(obj.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
//		System.out.println(obj.maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
//		System.out.println(obj.maxProfit(new int[] { 6, 1, 3, 2, 4, 7 }));
//		System.out.println(obj.maxProfit(new int[] { 0, 7, 2, 9, 4, 10 }));
//		System.out.println(obj.maxProfit(new int[] { 8, 3, 6, 2, 8, 8, 8, 4, 2, 0, 7, 2, 9, 4, 9 }));
		
		
		System.out.println(obj.maxProfit(new int[] { 3, 15, 7, 27, 3 }));
	}
	
	
	public int maxProfit(int[] prices) {
		int firstBuy = Integer.MAX_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MIN_VALUE;
		int secondSell = 0;
		for (int curPrice : prices) {
			firstBuy = Math.min(firstBuy, curPrice); 
			firstSell = Math.max(firstSell, curPrice - firstBuy); 
			secondBuy = Math.max(secondBuy, firstSell - curPrice);  //current profit
			secondSell = Math.max(secondSell, secondBuy + curPrice); 
			
			System.out.println(curPrice + "       A " + firstBuy + " B " + firstSell + " C " + secondBuy + " D " + secondSell);
		}
		return secondSell; 
	}

	public int maxProfit02(int[] prices) {
		// these four variables represent your profit after executing
		// corresponding transaction
		// in the beginning, your profit is 0.
		// when you buy a stock ,the profit will be deducted of the price of
		// stock.
		int firstBuy = Integer.MIN_VALUE, firstSell = 0;
		int secondBuy = Integer.MIN_VALUE, secondSell = 0;

		for (int curPrice : prices) {
			if (firstBuy < -curPrice){
				firstBuy = -curPrice;
			}
			if (firstSell < firstBuy + curPrice){
				firstSell = firstBuy + curPrice; 
			}
			if (secondBuy < firstSell - curPrice){
				secondBuy = firstSell - curPrice; 
			}
			if (secondSell < secondBuy + curPrice){
				secondSell = secondBuy + curPrice; 
			}
		}

		return secondSell;
	}



	public int maxProfitN(int[] prices) {
		int[] result = getProfilt(prices, 0);
		return result[0] + result[1];
	}

	Map<Integer, int[]> map = new HashMap<Integer, int[]>();

	public int[] getProfilt(int[] prices, int start) {
		int m0 = 0;
		int m1 = 0;
		// if (map.containsKey(start)) {
		// return map.get(start);
		// }
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while (!q.isEmpty()) {
			int i = q.poll();
			int j = i;
			while (j < prices.length) {
				if (j <= prices.length - 2 && prices[j + 1] > prices[j]) {
					j++;
				} else if (j == i) {
					i++;
					j = i;
					// break;
				} else {
					int p = prices[j] - prices[i];
					int[] array = getProfilt(prices, j + 1);
					// System.out.println(start + " Result " + array[0] + "-" +
					// array[1] + " I:" + i + " J:" + j + " P:" + p);
					PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
					queue.add(array[0]);
					queue.add(array[1]);
					queue.add(p);
					// if (queue.peek() > m0) {
					// m0 = queue.poll();
					// if (queue.peek() > m1) {
					// m1 = queue.poll();
					// }
					// } else if (queue.peek() > m1) {
					// m1 = queue.poll();
					// }
					int t0 = m0;
					int t1 = m1;
					int q0 = 0;
					int q1 = 0;
					if (!queue.isEmpty()) {
						q0 = queue.poll();
					}
					if (!queue.isEmpty()) {
						q1 = queue.poll();
					}
					if (q0 + q1 > m0 + m1) {
						m0 = q0;
						m1 = q1;
					}
					if (j == 8) {
						System.out.println(start + " Result " + (j + 1) + " is " + array[0] + "-" + array[1] + " I:" + i
								+ " J:" + j + " P:" + p + "   Max " + m0 + "-" + m1 + "  Pre " + t0 + "-" + t1);
					}
					// System.out.println(start + " Max " + m0 + "-" + m1);
					// i = j + 1;
					q.offer(j + 1);
					j++;
					// break;
				}
			}
		}

		int[] r = new int[2];
		r[0] = m0;
		r[1] = m1;

		// map.put(start, r);
		return r;
	}
}
