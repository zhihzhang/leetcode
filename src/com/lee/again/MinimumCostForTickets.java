package com.lee.again;

public class MinimumCostForTickets {

	public static void main(String[] args) {
		MinimumCostForTickets obj = new MinimumCostForTickets();
		System.out.println(obj.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{7,2,15}));
	}

	public int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[days.length];
		dp[0] = costs[0];
		for (int i = 1; i < 3; i++) {
			dp[0] = Math.min(dp[0], costs[i]);
		}
		

		for (int i = 1; i < days.length; i++) {
			dp[i] = dp[i - 1] + costs[0];
			
			int k = i - 1;
			while (k >= 0 && days[i] - days[k] < 7) {
				k--;
			}
			if(k<0){
				dp[i] = Math.min(dp[i], costs[1]);
			}else{
				dp[i] = Math.min(dp[i], dp[k] + costs[1]);
			}
			
			
			k = i - 1;
			while (k >= 0 && days[i] - days[k] < 30) {
				k--;
			}
			if(k<0){
				dp[i] = Math.min(dp[i], costs[2]);
			}else{
				dp[i] = Math.min(dp[i], dp[k] + costs[2]);
			}
		}
		return dp[days.length - 1];
	}

}
