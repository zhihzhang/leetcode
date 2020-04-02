package com.lee.againt;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		System.out.println(obj.maxProduct(new int[]{2, 3, -2, 4}));
		System.out.println(obj.maxProduct(new int[]{-2, 0, -1}));
		System.out.println(obj.maxProduct(new int[]{-2}));
		System.out.println(obj.maxProduct(new int[]{-4, -3, -2}));

	}

	// [2,3,-2,4]
	// [-2,0,-1]
	// [-4,-3,-2]

	public int maxProduct(int[] nums) {
		int max = 0;
		int[] dp1 = new int[nums.length];
		int[] dp2 = new int[nums.length];
		max = nums[0];
		if (nums[0] == 0) {
			dp1[0] = 0;
			dp2[0] = 0;
		} else if (nums[0] > 0) {
			dp1[0] = nums[0];
			dp2[0] = 0;
		} else {
			dp1[0] = 0;
			dp2[0] = nums[0];
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) {
				dp1[i] = 0;
				dp2[i] = 0;
			} else if (nums[i] > 0) {
				dp1[i] = Math.max(dp1[i-1] * nums[i], nums[i]);
				dp2[i] = Math.min(dp2[i-1] * nums[i], nums[i]);
			} else {
				dp1[i] = Math.max(dp2[i-1] * nums[i], nums[i]);
				dp2[i] = Math.min(dp1[i-1] * nums[i], nums[i]);
			}
			max = Math.max(max, dp1[i]);
		}
		return max;
	}

}
