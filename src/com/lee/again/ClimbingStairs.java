package com.lee.again;

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs obj = new ClimbingStairs();

	}
	
//	Example 1:
//
//		Input: 2
//		Output: 2
//		Explanation: There are two ways to climb to the top.
//		1. 1 step + 1 step
//		2. 2 steps
//		Example 2:
//
//		Input: 3
//		Output: 3
//		Explanation: There are three ways to climb to the top.
//		1. 1 step + 1 step + 1 step
//		2. 1 step + 2 steps
//		3. 2 steps + 1 step
	
    public int climbStairs(int n) {
    	int[] dp = new int[n];
    	dp[0]=1;
    	dp[1]=2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
        return dp[n-1];
    }

}
