package com.lee.aafour;

import java.util.Arrays;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{0,1,2,3,4,5,6,7,8};
		System.out.println(Arrays.binarySearch(nums, 0, 5, 0));
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return search(nums, target, 0, nums.length - 1);
	}

	// Input: nums = [4,5,6,7,0,1,2], target = 0
	public int search(int[] nums, int target, int l, int r) {
		if (r < l) {
			return -1;
		}
		if(nums[l]==target){
			return l;
		} else if (nums[r]==target){
			return r;
		}
		if (nums[l] < nums[r]) {
			int result = Arrays.binarySearch(nums, l, r, target);
			if (result < 0) {
				return -1;
			}
			return result;
		}

		int m = l + (r - l) / 2;
		if (nums[m] == target) {
			return m;
		} else if (nums[m] > nums[l] && target > nums[m]) {
			return search(nums, target, m + 1, r);
		} else if (nums[m] > nums[l] && target < nums[m] && target > nums[l]) {
			return search(nums, target, l, m-1);
		} else if (nums[m] > nums[l] && target < nums[r]) {
			return search(nums, target, m + 1, r);
		} else if (nums[m] < nums[r] && target < nums[m]) {
			return search(nums, target, l, m-1);
		} else if (nums[m] < nums[r] && target < nums[r] && target > nums[m]) {
			return search(nums, target, m + 1, r);
		} else if (nums[m] < nums[r] && target > nums[r]) {
			return search(nums, target, l, m-1);
		}
		return -1;
	}

}
