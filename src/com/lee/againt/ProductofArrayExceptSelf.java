package com.lee.againt;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
		int[] nums = new int[]{1,2,3,4};
		int[] r = obj.productExceptSelf(nums);
		System.out.println(Arrays.toString(r));
	}

	public int[] productExceptSelf(int[] nums) {
		int[] temp = Arrays.copyOf(nums, nums.length);
		temp[0] = 1;
		temp[1] = nums[0];

		for (int i = 2; i < temp.length; i++) {
			temp[i] = temp[i - 1] * nums[i - 1];
		}
		int pro = 1;
		for (int i = temp.length - 2; i >= 0; i--) {
			pro *= nums[i+1];
			temp[i] = pro * temp[i];
		}
		return temp;
	}

}
