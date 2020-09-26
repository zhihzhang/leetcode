package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {

	public static void main(String[] args) {
		int[] A = new int[]{4,5,0,-2,-3,1};
		SubarraySumsDivisiblebyK obj = new SubarraySumsDivisiblebyK();
		System.out.println(obj.subarraysDivByK(A, 5));

	}

//	[4,5,0,-2,-3,1],K=5

	public int subarraysDivByK(int[] A, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		for (int n : A) {
			sum += n;
			int t = sum % K;
			if (t < 0) {
				t = t + K;
			}
			map.put(t, map.getOrDefault(t, 0) + 1);
			count += map.get(t) - 1;
		}
		return count;

	}

}
