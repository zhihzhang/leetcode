package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		int[] nums = new int[]{-2, 1, 1, 1, 3, 4};
		List<List<Integer>> result = obj.threeSum(nums);
		System.out.println(result.toString());

	}

	// -4, -1, -1, 1, 2, 3
	// -2, 1, 1, 1, 3, 4
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int t = nums[i];
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				if (nums[l] + nums[r] + t == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(t);
					list.add(nums[l]);
					list.add(nums[r]);
					result.add(list);
					r--;
					while (l < r && nums[r] == nums[r + 1]) {
						r--;
					}
					l++;
					while (l < r && nums[l] == nums[l - 1]) {
						l++;
					}
				} else if (nums[l] + nums[r] + t > 0) {
					r--;
					while (l < r && nums[r] == nums[r + 1]) {
						r--;
					}
				} else {
					l++;
					while (l < r && nums[l] == nums[l - 1]) {
						l++;
					}
				}
			}
		}
		return result;
	}
}
