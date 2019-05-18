package com.lee.again;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
		System.out.println(Arrays.toString(obj.productExceptSelf(new int[]{1,2,3,4})));
	}

	// 1, 2, 3, 4
	// 1, 1, 2, 6
	// 24,12,8, 6 
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return nums;
		}
		int[] array = Arrays.copyOf(nums, nums.length);

		nums[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = array[i - 1] * nums[i - 1];
		}
		int t = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			t = t * array[i+1];
			nums[i] = t * nums[i];
		}
		return nums;
	}

}
