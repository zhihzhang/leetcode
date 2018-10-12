package com.lee.dp;

import java.util.Arrays;

public class Rob198 {

	public static void main(String[] args) {
		Rob198 obj = new Rob198();
		int w = obj.rob(new int[] { 1, 2, 3, 1 });
		System.out.println(w);
	}
	
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 1) {
			return Math.max(nums[0], nums[1]);
		}
		
		long[] total = new long[nums.length];
		boolean[] hasLast = new boolean[nums.length];
		Arrays.fill(hasLast, false);
		total[0] = nums[0];
		hasLast[0] = true;
		total[1] = Math.max(nums[0], nums[1]);
		if (nums[1] > nums[0]) {
			hasLast[1] = true;
		}
		for (int i = 2; i < nums.length; i++) {
			if (!hasLast[i - 1]) {
				long m = Math.max(total[i - 1], total[i - 2]);
				total[i] = nums[i] + m;
				hasLast[i] = true;
			} else {
				if (nums[i] + total[i - 2] > total[i - 1]) {
					hasLast[i] = true;
					total[i] = nums[i] + total[i - 2];
				} else {
					total[i] = total[i-1];
				}
			}

		}
		return (int)total[nums.length - 1];
	}

}
