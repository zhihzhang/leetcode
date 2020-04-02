package com.lee.againt;

import java.util.Arrays;

public class SortColor {

	public static void main(String[] args) {
		SortColor obj = new SortColor();
		int[] nums = new int[] {0};
		obj.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < nums.length && nums[left] == 0) {
			left++;
		}
		while (right >= 0 && nums[right] == 2) {
			right--;
		}

		int i = left;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(i, left, nums);
				while (nums[left] == 0 && left < nums.length) {
					left++;
				}
				i = left;
			} else if (nums[i] == 2) {
				swap(i, right, nums);
				while (nums[right] == 2 && right >= 0) {
					right--;
				}
			} else {
				i++;
			}
		}
	}

	public void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
