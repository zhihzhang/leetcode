package com.lee.againt;

public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int t = obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(t);

	}

	// Input: [-2,1,-3,4,-1,2,1,-5,4],
	// Output: 6
	// Explanation: [4,-1,2,1] has the largest sum = 6.

	public int maxSubArray(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		int sum = dp[0];
		for (int i = 1; i < nums.length; i++) {
			
			if (dp[i-1] >= 0) {
				dp[i] = nums[i] + dp[i-1];
			} else {
				dp[i] = nums[i];
			}
			sum = Math.max(dp[i], sum);
		}
		return sum;
	}

}
