package com.lee.binarysearch;

public class SearchInsertP35 {

	public static void main(String[] args) {
		SearchInsertP35 obj = new SearchInsertP35();
		System.out.println(obj.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(obj.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(obj.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(obj.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
	}

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return target > nums[0] ? 1 : 0;
		}

		int l = 0;
		int r = nums.length - 1;
		int m = 0;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (nums[m] == target) {
				return m;
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return nums[m] > target ? m : m + 1;
	}

}
