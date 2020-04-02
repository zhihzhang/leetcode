package com.lee.again;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> indexMap = new HashMap<>();
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (!indexMap.containsKey(c)) {
				indexMap.put(c, i);
			}
		}
		for (char c : a) {
			if (map.get(c) == 1) {
				return indexMap.get(c);
			}
		}
		return 0;
	}

}
