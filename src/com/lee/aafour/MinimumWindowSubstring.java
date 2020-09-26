package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring obj = new MinimumWindowSubstring();
		obj.minWindow("a", "a");

	}

	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = map.size();
		int l = 0;
		String str = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int v = map.get(c) - 1;
				map.put(c, v);
				if (v == 0) {
					count--;
				}
			} else {
				continue;
			}
			if (count == 0) {
				while (l <= i && count == 0) {
					String w = s.substring(l, i + 1);
					if (str==null || w.length() < str.length() ) {
						str = w;
					}
					c = s.charAt(l);
					if (map.containsKey(c)) {
						int v = map.get(c) + 1;
						map.put(c, v);
						if (v == 1) {
							count++;
						}
					}
					l++;
				}
			}
		}
		return str==null?"":str;
	}

}
