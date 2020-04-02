package com.lee.again;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		SearchinRotatedSortedArray obj = new SearchinRotatedSortedArray();
//		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums = new int[] { 5, 1, 2, 3, 4 };
		System.out.println(obj.search(nums, 1));
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0;
		int r = nums.length - 1;
		int v0 = nums[0];
		int v1 = nums[r];
		if (v0 == target) {
			return 0;
		}
		if (v1 == target) {
			return r;
		}

		while (l <= r) {
			int n = (l + r) / 2;
			int v = nums[n];

			// int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
			// int[] nums = new int[] { 4, 5, 6, 7, 0};
			// int[] nums = new int[] { 9, 10, 0, 1, 2, 3, 4, 5, 6 };
			if (v == target) {
				return n;
			}
			if (target > v0) {
				if (target > v) {
					if (v >= v0) {
						l = n + 1;
					} else {
						r = n - 1;
					}
				} else {
					r = n - 1;
				}
			} else {
				if (target < v) {
					if (v >= v0) {
						l = n + 1;
					} else {
						r = n - 1;
					}
				} else {
					l = n + 1;
				}
			}
		}

		return -1;
	}

}
