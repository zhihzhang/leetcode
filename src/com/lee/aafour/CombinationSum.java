package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		backTrace(candidates, target, list, result, 0);
		System.out.println(result.toString());
		return result;
	}

	public void backTrace(int[] nums, int target, List<Integer> list, List<List<Integer>> result, int index) {
		if (target == 0) {
			List<Integer> t = new ArrayList<>();
			t.addAll(list);
			result.add(t);
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			int n = nums[i];
			list.add(n);
			backTrace(nums, target - n, list, result, i);
			list.remove(list.size() - 1);
		}
	}

}
