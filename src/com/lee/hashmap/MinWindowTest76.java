package com.lee.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MinWindowTest76 {

	public static void main(String[] args) {
		MinWindowTest76 obj = new MinWindowTest76();

		String s = "1234567890";
		System.out.println(s.substring(0, 5));

		String r = null;

		r = obj.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(r);

		r = obj.minWindow("A", "B");
		System.out.println(r);

		r = obj.minWindow("bba", "ab");
		System.out.println(r);
	}

	public String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int l = 0;
		int r = 0;
		int min = Integer.MAX_VALUE;
		int count = 0;

		int left = 0;

		while (r < s.length()) {
			if (count < t.length()) {
				char c = s.charAt(r);
				if (map.containsKey(c)) {
					if (map.get(c) > 0) {
						count++;
					}
					map.put(c, map.get(c) - 1);
				}
			}
			while (count == t.length()) {
				if (min > r - l + 1) {
					min = r - l + 1;
					left = l;
				}
				char c = s.charAt(l);
				if(map.containsKey(c)){
					if (map.get(c) >= 0) {
						count--;
					}
					map.put(c, map.get(c) + 1);
				}
				l++;
			}
			r++;
		}
		
		if(min == Integer.MAX_VALUE){
			return "";
		}

		return s.substring(left, left + min);
	}

}
