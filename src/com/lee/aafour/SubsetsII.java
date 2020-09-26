package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubsetsII {

	public static void main(String[] args) {
		SubsetsII obj = new SubsetsII();
		int[] nums = new int[]{1,2,2};
		System.out.println(obj.subsetsWithDup(nums));
	}

	// [1,2,2]
	// [
	// [2],
	// [1],
	// [1,2,2],
	// [2,2],
	// [1,2],
	// []
	// ]

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		backTrace(result, list, nums, 0);
		return result;
	}

	public void backTrace(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && i>start) {
				continue;
			}
			list.add(nums[i]);
			List<Integer> t = new ArrayList<>();
			t.addAll(list);
			result.add(t);
			backTrace(result, list, nums, i + 1);
			list.remove((Object) nums[i]);
		}
	}

}
