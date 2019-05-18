package com.lee.again;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		SortColors obj = new SortColors();
		// int[] nums = new int[]{2,0,1};
//		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
		int[] nums = new int[] { 0,0};
		obj.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	// Input: [2,0,2,1,0,2,1,0,1]
	// Output: [0,0,0,1,1,1,2,2,2]

	// 2 0 1
	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i < nums.length) {
			if (nums[i] == 0) {
				if (i == left) {
					i++;
				} else {
					swap(nums, i, left);
				}
				// while (left < nums.length && nums[left] == 0) {
				// left++;
				// }
				left++;
				continue;
			} else if (nums[i] == 2) {
				if (i > right) {
					return;
				}
				if (i == right) {
					i++;
				} else {
					swap(nums, i, right);
				}
				// while (right >= 0 && nums[right] == 2) {
				// right--;
				// }
				right--;
				continue;
			}
			i++;
		}
	}

	public void swap(int[] nums, int a, int b) {
		if (b >= nums.length || b < 0) {
			return;
		}
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;

	}

}
