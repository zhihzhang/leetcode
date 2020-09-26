package com.lee.aafour;

import java.util.Arrays;

public class NumberLongestIncreasingSubsequence {

	public static void main(String[] args) {
		NumberLongestIncreasingSubsequence obj = new NumberLongestIncreasingSubsequence();
		int[] nums =new int[]{1,3,5,4,7};
		int t = obj.findNumberOfLIS(nums);
		
		System.out.println(t);
		
		obj.findNumberOfLIS(new int[]{2,2,2,2,2});
	}

	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int[] count = new int[nums.length];
		Arrays.fill(dp, 1);
		count[0]=1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] == dp[j]+1) {
					count[i]++;
				}
			}
			if(count[i]==0){
				count[i]=1;
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(count));
		int max = 0;
		for (int n : dp) {
			max = Math.max(max, n);
		}
		int t = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == max) {
				t += count[i];
			}
		}
		return t;
	}

}
