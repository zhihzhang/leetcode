package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum obj = new ThreeSum();
		// System.out.println(obj.threeSum(new int[] { -1, 0, 1, 2, -1, -4
		// }).toString());
		System.out.println(obj.threeSum(new int[] { -2, 0, 1, 1, 2 }).toString());
		System.out.println(obj.threeSum(new int[] { -2, -1, -1, 0, 1, 1, 2 }).toString());
		// -4,-1,-1,0,1,2
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Set<String> set = new HashSet<>();
		for (int l = 0; l < nums.length - 2; l++) {
			int r = nums.length - 1;
			while (r >= l + 2) {
				int sum = nums[l] + nums[r];
				int key = 0 - sum;
				if (map.containsKey(key)) {
					int count = 1;
					if (key == nums[l]) {
						count++;
					}
					if (key == nums[r]) {
						count++;
					}
					if (map.get(key) >= count) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[l]);
						list.add(key);
						list.add(nums[r]);
						Collections.sort(list);
						String k = list.toString();
						if (!set.contains(k)) {
							set.add(k);
							result.add(list);
						}
					}
				}
				if (key > nums[nums.length - 1]) {
					break;
				}
				r--;
			}
		}
		return result;
	}

}
