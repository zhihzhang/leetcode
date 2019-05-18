package com.lee.again;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence60 {

	public static void main(String[] args) {
		PermutationSequence60 obj = new PermutationSequence60();
		String s = obj.getPermutation(4, 9);
		System.out.println(s);
	}

	int count = 0;
	// List<String> result = new ArrayList<>();
	StringBuffer sb = new StringBuffer("");
	boolean foundResult = false;

	public String getPermutation(int n, int k) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(i + 1);
		}

		backTrace(nums, new ArrayList<Integer>(), n, k);

		return sb.toString();
	}

	public void backTrace(List<Integer> nums, List<Integer> list, int n, int k) {
		if (list.size() == n) {
			count++;
			if (count == k) {
				for (int i : list) {
					sb.append(i + "");
				}
				foundResult = true;
				return;
			}
		}
		for (int i = 0; i < nums.size(); i++) {
			list.add(nums.get(i));
			List<Integer> temp = new ArrayList<>();
			temp.addAll(nums);
			temp.remove((Object) nums.get(i));
			backTrace(temp, list, n, k);
			if (foundResult) {
				return;
			}
			list.remove(list.size() - 1);
		}
	}

}
