package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		// List<Integer> numsList = new ArrayList<>();
		// for(int i:nums){
		// numsList.add(i);
		// }
		backtrace(nums, list, result);
		return result;
	}

	public void backtrace(int[] nums, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			List<Integer> t = new ArrayList<>();
			t.addAll(list);
			result.add(t);
			return;
		}
		for (int i : nums) {
			if (!list.contains(i)) {
				list.add(i);
				backtrace(nums, list, result);
				list.remove((Object) i);
			}
		}
	}

}
