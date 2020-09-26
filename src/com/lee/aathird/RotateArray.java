package com.lee.aathird;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		RotateArray obj = new RotateArray();
		int[] nums = new int[]{1,2,3,4,5,6,7};
		obj.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));

	}

	// Input: [1,2,3,4,5,6,7] and k = 3
	// Output: [5,6,7,1,2,3,4]
	public void rotate(int[] nums, int k) {
		ro(nums, 0, nums.length - 1);
		if(k<nums.length){
			ro(nums, 0, k-1);
			ro(nums, k, nums.length - 1);
		}
	}
	
	public void ro(int[] nums, int l, int r) {
		while (l < r) {
			int t = nums[l];
			nums[l] = nums[r];
			nums[r] = t;
			l++;
			r--;
		}
	}

}
