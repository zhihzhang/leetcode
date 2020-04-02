package com.lee.againt;

import java.util.Arrays;

public class SearchinRotated {

	public static void main(String[] args) {
		SearchinRotated obj = new SearchinRotated();
		System.out.println(obj.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		// System.out.println(obj.search(new int[] { 4, 5, 6, 7, 8, 9, 11, 0, 1,
		// 2 }, 61));
		// System.out.println(obj.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		// System.out.println(obj.search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 },
		// 8));

		// System.out.println(Arrays.binarySearch(new int[] { 1, 2, 3, 4, 5, 6
		// }, 0, 4, 4));
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int result = search(nums, 0, nums.length - 1, target);
		if (result < 0) {
			return -1;
		}
		return result;
	}

	public int search(int[] nums, int l, int r, int target) {
		if (l > r) {
			return -1;
		}
		int m = (l + r) / 2;
		if (nums[m] == target) {
			return m;
		} else if (nums[l] == target) {
			return l;
		} else if (nums[r] == target) {
			return r;
		} else if (nums[l] < nums[r]) {
			return Arrays.binarySearch(nums, l, r + 1, target);
		}
		if (target < nums[m] && target > nums[l]) {
			return Arrays.binarySearch(nums, l, m, target);
		} else if (target > nums[m] && target < nums[r]) {
			return Arrays.binarySearch(nums, m + 1, r + 1, target);
		} else if (target > nums[m] && target > nums[l] && nums[m]>nums[l]) {
			return search(nums, m + 1, r, target);
		} else if (target < nums[m] && target < nums[r] && nums[m]>nums[l]) {
			return search(nums, m + 1, r, target);
		} else if (target > nums[m] && target > nums[l] && nums[m]<nums[r]) {
			return search(nums, l, m - 1, target);
		} else if (target < nums[m] && target < nums[r] && nums[m]<nums[r]) {
			return search(nums, l, m - 1, target);
		} 
		return -1;
	}

}
