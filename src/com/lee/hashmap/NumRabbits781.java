package com.lee.hashmap;

import java.util.HashMap;
import java.util.Map;

public class NumRabbits781 {

	public static void main(String[] args) {
		NumRabbits781 obj = new NumRabbits781();
		int k = obj.numRabbits(new int[]{0,0,1,1,1});
		System.out.println(k);
	}

	public int numRabbits(int[] answers) {
		if (answers == null || answers.length == 0) {
			return 0;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int k : answers) {
			map.put(k, map.getOrDefault(k, 0) + 1);

		}
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() == 0) {
				count = count + entry.getValue();
				continue;
			}
			if (entry.getValue() > entry.getKey() + 1) {
				count = (int) (count + Math.ceil( (double)entry.getValue() / (double)(entry.getKey() + 1)) * (entry.getKey() + 1));
			} else {
				count = count + entry.getKey() + 1;
			}
		}
		return count;
	}

}
