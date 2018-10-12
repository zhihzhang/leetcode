package com.lee.twopointers;

public class MaxSubArray53 {

	public static void main(String[] args) {
		MaxSubArray53 obj = new MaxSubArray53();
		
	}
	
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int current = 0;
		for (int i = 0; i < nums.length; i++) {
			current = current + nums[i];
			current = Math.max(current, current + nums[i]);
			max = Math.max(current, max);
		}
		return max;
	}

}
