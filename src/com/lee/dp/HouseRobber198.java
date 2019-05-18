package com.lee.dp;

public class HouseRobber198 {

	public static void main(String[] args) {
		HouseRobber198 obj = new HouseRobber198();

	}
	
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		
		long[] total = new long[nums.length];
		total[0]=nums[0];
		total[1]= Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			total[i] = Math.max(total[i-1], nums[i] + total[i-2]);
		}
		return (int)total[nums.length - 1];
	}

}
