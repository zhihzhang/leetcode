package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations obj = new Permutations();
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = obj.permute(nums);
		System.out.println(result.toString());
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> r = new ArrayList<>();
		backtrace(nums, r, result);
		return result;
	}

	public void backtrace(int[] nums, List<Integer> r, List<List<Integer>> result) {
		if (r.size() == nums.length) {
			List<Integer> list = new ArrayList<>();
			list.addAll(r);
			result.add(list);
			return;
		}
		for (int n : nums) {
			if (!r.contains(n)) {
				r.add(n);
				backtrace(nums, r, result);
				r.remove((Integer)n);
			}
		}
	}

}
