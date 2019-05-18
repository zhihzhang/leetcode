package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombinationSum39 {

	public static void main(String[] args) {
		CombinationSum39 obj = new CombinationSum39();
		System.out.println(obj.combinationSum(new int[]{9,6,8,11,5,4},34));

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> r = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, list, r, 0);
		return r;
	}

	public void backtrack(int[] candidates, int target, List<Integer> list, List<List<Integer>> r, int index) {
		for (int i=index;i<candidates.length;i++) {
			int c = candidates[i];
			if (c == target) {
				List t = new ArrayList<>();
				t.addAll(list);
				t.add(c);
				r.add(t);
				break;
			} else if (c < target) {
				list.add(c);
				backtrack(candidates, target - c, list, r, i);
				list.remove(list.size() - 1);
			} else {
				break;
			}
		}
	}

}
