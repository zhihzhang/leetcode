package com.lee.binarysearch;

public class RotatedArraySearch81 {

	public static void main(String[] args) {
		RotatedArraySearch81 obj = new RotatedArraySearch81();
		// System.out.println(obj.check(new int[]{2,5,6,0,0,1,2}, 7));
		System.out.println(obj.check(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1 }, 3));

	}

	public boolean search(int[] nums, int target) {
		int r = check(nums, target);
		return r == -1 ? false : true;
	}

	public int check(int[] nums, int target) {
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

			// 13,14,15,16,17,18,1,2,3,4,5,6,7,8

			if (nums[mid] < nums[right]) {
				if (target < nums[mid]) {
					right = mid - 1;
					continue;
				}
				if (target > nums[mid] && target > nums[right]) {
					right = mid - 1;
					continue;
				}
				if (target > nums[mid] && target < nums[right]) {
					left = mid + 1;
					continue;
				}
			} else if (nums[mid] > nums[right]) {
				if (target > nums[mid]) {
					left = mid + 1;
					continue;
				}
				if (target < nums[mid] && target > nums[left]) {
					right = mid - 1;
					continue;
				}
				if (target < nums[mid] && target < nums[left]) {
					left = mid + 1;
					continue;
				}
			} else {
				right--;
			}
		}
		return -1;
	}

}
