package com.lee.again;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		int[] r = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int k = target - numbers[i];
			if (map.containsKey(k)) {
				if(i == map.get(k)){
					continue;
				}
				r[0] = i + 1;
				r[1] = map.get(k) + 1;
				return r;
			}
		}
		return r;
    }

}
