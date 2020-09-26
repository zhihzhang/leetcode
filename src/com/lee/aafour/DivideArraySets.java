package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivideArraySets {

	public static void main(String[] args) {
		DivideArraySets obj = new DivideArraySets();
		System.out.println(obj.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));

	}

	//nums = [1,2,3,3,4,4,5,6], k = 4
	// 11 22 33 3
	public boolean isPossibleDivide(int[] nums, int k) {
		Arrays.sort(nums);

		Map<Integer, Integer> pre = new HashMap<Integer, Integer>();
		for (int n : nums) {
			if (pre.getOrDefault(n, 0) == 0) {
				for (int i = 1; i < k; i++) {
					pre.put(n + i, pre.getOrDefault(n + i, 0) - 1);
				}
			} else if (pre.getOrDefault(n, 0) < 0) {
				pre.put(n, pre.getOrDefault(n, 0) + 1);
			}
		}
		for (int n : pre.values()) {
			if (n < 0) {
				return false;
			}
		}
		return true;
	}

}
