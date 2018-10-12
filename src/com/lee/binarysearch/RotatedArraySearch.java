package com.lee.binarysearch;

public class RotatedArraySearch {

	public static void main(String[] args) {
		RotatedArraySearch obj = new RotatedArraySearch();
		System.out.println(obj.search(new int[] { 11, 12, 13, 1, 2, 3, 4, 5 }, 3));
		System.out.println(obj.search(new int[] { 5, 1, 2, 3, 4 }, 1));
		System.out.println(obj.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));

	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (right + left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[left] == target) {
				return left;
			}
			if (nums[right] == target) {
				return right;
			}

		//  13,14,15,16,17,18,1,2,3,4,5,6,7,8
			
			if (nums[mid] <= nums[right]) {
				if (target < nums[mid]) {
					right = mid - 1;
					continue;
				}
				if (target > nums[mid] && target>nums[right]) {
					right = mid - 1;
					continue;
				}
				if (target > nums[mid] && target<nums[right]) {
					left = mid + 1;
					continue;
				}
			} else {
				if (target > nums[mid]) {
					left = mid + 1;
					continue;
				}
				if (target < nums[mid] && target>nums[left]) {
					right = mid - 1;
					continue;
				}
				if (target < nums[mid] && target<nums[left]) {
					left = mid + 1;
					continue;
				}
			}
		}
		return -1;
	}

}
