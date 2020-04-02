package com.lee.again;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		MaximumProductSubarray obj = new MaximumProductSubarray();

	}

	public int maxProduct(int[] nums) {
		int l = 0;
		int sum = nums[l];
		int max = sum;
		while (nums[l] == 0 && l < nums.length) {
			l++;
		}
		int r = l + 1;

		while (l < r && r < nums.length) {
			sum = sum * nums[r];
			max = Math.max(sum, max);
			
		}

		return (int)max;
	}

}
