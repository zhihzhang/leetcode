package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		backTrace(candidates, target, 0, list, result);
		return result;
	}

	public void backTrace(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> result) {
		if (target == 0) {
			List<Integer> t = new ArrayList<>();
			t.addAll(list);
			result.add(t);
		}
		if (target < 0) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(i>0 && candidates[i] == candidates[i-1] && i-1!=index){
				continue;
			}
			list.add(candidates[i]);
			backTrace(candidates, target - candidates[i], i + 1, list, result);
			list.remove(list.size() - 1);
		}
	}

}
