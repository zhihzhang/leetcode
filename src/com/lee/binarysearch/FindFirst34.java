package com.lee.binarysearch;

import java.util.Arrays;

public class FindFirst34 {

	public static void main(String[] args) {
		FindFirst34 obj = new FindFirst34();
		System.out.println(Arrays.toString(obj.searchRange(new int[] { 1,3 }, 1)));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		if (nums.length == 1 && nums[0] == target) {
			return new int[] { 0, 0 };
		}
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) { // use equal
			int i = l + (r - l) / 2;  // binary search
			if (target == nums[i]) {
				int a = i;
				int b = i;
				while (a >= 0 && nums[a] == target) {
					a--;
				}
				if (a < 0) {
					a = 0;
				} else {
					a++;
				}

				while (b <= nums.length - 1 && nums[b] == target) {
					b++;
				}
				if (b >= nums.length) {
					b = nums.length - 1;
				} else {
					b--;
				}

				return new int[] { a, b };
			} else if (nums[i] < target) {
				l = i + 1;
			} else {
				r = i - 1;
			}
		}
		return new int[] { -1, -1 };
	}

}
