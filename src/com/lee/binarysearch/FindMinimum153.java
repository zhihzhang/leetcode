package com.lee.binarysearch;

public class FindMinimum153 {
	public static void main(String[] args) {
		FindMinimum153 obj = new FindMinimum153();

		System.out.println(obj.findMin(new int[] { 1,2 }));
	}

	public int findMin(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int l = 0;
		int r = nums.length - 1;
		
		if(nums[l]<nums[r]){
			return nums[l];
		}
		// int min = Integer.MAX_VALUE;
		int m = 0;
		while (l < r) {
			m = l + (r - l) / 2;
			if (nums[m] < nums[r]) {
				r = m - 1;
				if (nums[m - 1] > nums[m]) {
					break;
				}
			} else {
				l = m + 1;
				if (nums[m + 1] < nums[m]) {
					m = m + 1;
					break;
				}
			}
		}
		return nums[m];
	}
}
