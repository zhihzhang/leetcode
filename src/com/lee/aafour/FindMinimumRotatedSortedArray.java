package com.lee.aafour;

public class FindMinimumRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	3,4,5,1,2
//	4,5,6,7,0,1,2
	//4,0,1,2
	public int findMinWork(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0;
		int r = nums.length - 1;
		int min = Integer.MAX_VALUE;
		if(nums[l]<=nums[r]){
			return nums[l];
		}
		while (l <= r) {
			int m = l + (r - l) / 2;
			min = Math.min(nums[m], min);
			if (nums[m] >= nums[l]) {
				if (m + 1 < nums.length && nums[m + 1] < nums[m]) {
					return nums[m + 1];
				}
				l = m + 1;
			} else {
				if (m - 1 >= 0 && nums[m - 1] > nums[m]) {
					return nums[m];
				}
				r = m - 1;
			}
		}
		return min;
	}
	

}
