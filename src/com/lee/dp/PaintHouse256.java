package com.lee.dp;

import java.util.Arrays;

public class PaintHouse256 {

	public static void main(String[] args) {
		PaintHouse256 obj = new PaintHouse256();
		int[][] costs = new int[][]{
			{17,2,17},
			{16,16,5},
			{14,3,19}
		};
		System.out.println(obj.minCost(costs));

	}
	
    public int minCost(int[][] costs) {
    	if(costs==null || costs.length==0){
    		return 0;
    	}
    	int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
		}
        
        n = n-1;
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }

}
