package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		int[] visited = new int[nums.length];
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, list, nums, visited);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int[] visited) {
		if (list.size() == nums.length) {
			List<Integer> t = new ArrayList<>();
			t.addAll(list);
			result.add(t);
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] > 0 || (i - 1 >= 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1])) {
				continue;
			}
			list.add(nums[i]);
			visited[i] = 1;
			backtrack(result, list, nums, visited);
			visited[i] = 0;
			list.remove(list.size() - 1);
		}
	}

}
