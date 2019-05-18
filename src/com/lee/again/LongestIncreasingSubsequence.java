package com.lee.again;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 1) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int max = 1;
		int i = 0;
		int j = 0;
		while (i < nums.length - 1) {
			j = i + 1;
			int length = 1;
			int t = i;
			while (j < nums.length) {
				if(nums[j] > nums[t]){
					t = j;
					length++;
				}
			}
			max = Math.max(max, length);
			i = j;
		}
		return max;
	}

}
