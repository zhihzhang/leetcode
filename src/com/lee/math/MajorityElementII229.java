package com.lee.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII229 {

	public static void main(String[] args) {
		MajorityElementII229 obj = new MajorityElementII229();
		List<Integer> list = obj.majorityElement(new int[]{1,1,1,3,3,2,2,2});
		System.out.println(list.toString());
	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		int threshold = nums.length / 3;
		System.out.println(threshold);

		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		for (Map.Entry<Integer, Integer> entry : list) {
			if (entry.getValue() > threshold) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
}
