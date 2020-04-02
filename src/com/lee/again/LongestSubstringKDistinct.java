package com.lee.again;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestSubstringKDistinct {

	public static void main(String[] args) {
		LongestSubstringKDistinct obj = new LongestSubstringKDistinct();
		System.out.println(obj.lengthOfLongestSubstringKDistinct("cdc8idaa;e", 1));

	}

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int max = 0;
		int start = 0;
		TreeMap<Character, Integer> map = new TreeMap<>();
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (map.containsKey(c)) {
				map.put(c, i);
				max = Math.max(max, i - start + 1);
			} else {
				if (map.size() == k) {
					char t = c;
					int min = Integer.MAX_VALUE;
					for (Map.Entry<Character, Integer> entry : map.entrySet()) {
						if (entry.getValue() < min) {
							min = entry.getValue();
							t = entry.getKey();
						}
					}
					map.remove(t);
					start = min + 1;
					map.put(c, i);
				} else {
					map.put(c, i);
					max = Math.max(max, i - start + 1);
				}
			}
		}
		return max;
	}

}
