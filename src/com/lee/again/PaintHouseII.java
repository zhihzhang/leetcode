package com.lee.again;

import java.util.PriorityQueue;
import java.util.Queue;

public class PaintHouseII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int[][] dp = new int[costs.length][costs[0].length];

		
		for (int i = 0; i < costs[0].length; i++) {
			dp[0][i] = costs[0][i];
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i < costs.length; i++) {
			Queue<Integer> queue = new PriorityQueue<>();
			for (int j = 0; j < costs[0].length; j++) {
				queue.add(costs[i - 1][j]);
			}
			for (int j = 0; j < costs[0].length; j++) {
				int v = costs[i - 1][j];
				int mv = Integer.MAX_VALUE;
				if (queue.peek() == v) {
					queue.poll();
					mv = queue.peek();
					queue.add(v);
				}

				dp[i][j] = costs[i][j] + mv;

				if (i == costs.length - 1) {
					min = Math.min(min, dp[i][j]);
				}
			}
		}
		
		if(min == Integer.MAX_VALUE){
			for (int i = 0; i < costs[0].length; i++) {
				min = Math.min(min, costs[0][i]);
			}
		}

		return min;

	}

}
