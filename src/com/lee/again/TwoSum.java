package com.lee.again;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum obj = new TwoSum();
		int[] a = obj.twoSum(new int[]{3,2,4}, 6);
		System.out.println(Arrays.toString(a));
		

	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int[] r = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int k = target - nums[i];
			if (map.containsKey(k)) {
				if(i == map.get(k)){
					continue;
				}
				r[0] = i;
				r[1] = map.get(k);
				return r;
			}
		}
		return r;
	}

}
