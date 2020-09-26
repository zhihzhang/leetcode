package com.lee.aafour;

public class FindMinimumRotatedSortedArrayTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1 2 3
	// 4 5 2 3 4
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0;
		int r = nums.length - 1;
		return findMin(nums, l, r);
	}

	public int findMin(int[] nums, int l, int r) {
		if (l > r) {
			return Integer.MAX_VALUE;
		}
		if (l == r) {
			return nums[l];
		}
		int m = l + (r - l) / 2;
		int min = nums[l];
		min = Math.min(min, nums[m]);
		if ((nums[m] > nums[l]) || (nums[m] == nums[l] && nums[l] > nums[r])) {
			if (m + 1 < nums.length && nums[m + 1] < nums[m]) {
				return nums[m + 1];
			}
			int v = findMin(nums, m+1, r);
			min = Math.min(min, v);
		} else if ((nums[m] < nums[r]) || (nums[m] == nums[r] && nums[l] > nums[r])) {
			if (m - 1 >= 0 && nums[m - 1] > nums[m]) {
				return nums[m];
			}
			int v = findMin(nums, l, m-1);
			min = Math.min(min, v);
		} else if (nums[m] == nums[l] && nums[l] == nums[r]) {
			int v1 = findMin(nums, l, m-1);
			int v2 = findMin(nums, m+1, r);
			int v = Math.min(v1, v2);
			min = Math.min(min, v);
		}
		return min;
	}

}
