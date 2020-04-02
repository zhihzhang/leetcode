package com.lee.again;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		for (int l = 1; l < nums.length; l++) {
			int i = 0;
			int sum = nums[i];
			for (int j = 1; j < l && j < nums.length; j++) {
				sum = nums[j] * sum;
			}
			int j = i+l;
			while(j<nums.length){
				
			}
		}
		
		return 0;
	}

}
