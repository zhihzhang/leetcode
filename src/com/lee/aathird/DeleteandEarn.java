package com.lee.aathird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DeleteandEarn {

	public static void main(String[] args) {
		DeleteandEarn obj = new DeleteandEarn();
		int[] nums = new int[] { 3,3,3,4,2 };
//		int[] nums = new int[] { 2, 2, 3, 3, 3, 4 };
		System.out.println(obj.deleteAndEarn(nums));
	}

	public int deleteAndEarn(int[] nums) {
		Arrays.sort(nums);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Map<Integer, Integer> sum = new HashMap<>();
		Map<Integer, Integer> idxMap = new HashMap<>();
		int i = 1;
		for (int n : nums) {
			if (!map.containsKey(n)) {
				map.put(n, i);
				idxMap.put(i++, n);
			}
			int t = map.get(n);
			sum.put(t, sum.getOrDefault(t, 0) + n);
		}

		int[] dp = new int[i];
		dp[0] = 0;
		dp[1] = sum.get(1);
		for (int j = 2; j < i; j++) {
			int n = idxMap.get(j);
			int m = idxMap.get(j - 1);
			if (n - m == 1) {
				dp[j] = Math.max(sum.get(j) + dp[j - 2], dp[j - 1]);
			} else {
				dp[j] = sum.get(j) + dp[j - 1];
			}
		}
		return dp[i - 1];
	}

}
