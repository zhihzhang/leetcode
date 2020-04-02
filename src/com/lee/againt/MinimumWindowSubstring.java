package com.lee.againt;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring obj = new MinimumWindowSubstring();
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(obj.minWindow("345ADOBECODEBANC", "ABC"));
		System.out.println(obj.minWindow("345ADOBECODEBANC", "A"));
		System.out.println(obj.minWindow("345ADOBECODEBANC", "3"));
		System.out.println(obj.minWindow("AA", "AA"));
		System.out.println(obj.minWindow("bba", "ab"));

	}

	public String minWindow(String s, String t) {
		if (t == null || t.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int min = Integer.MAX_VALUE;
		int l = 0;
		int r = 0;
		int count = map.size();
		String subStr = "";
		char[] ca = s.toCharArray();
		while (l < ca.length && r < ca.length) {
			while (r < ca.length && count > 0) {
				if (map.containsKey(ca[r])) {
					int x = map.get(ca[r]);
					map.put(ca[r], --x);
					if (x == 0) {
						count--;
					}
				}
				r++;
				if (count == 0) {
					if (r - l < min) {
						subStr = s.substring(l, r);
						min = subStr.length();
					}
				}
				
			}
			while (l < r && count == 0) {
				if (map.containsKey(ca[l])) {
					int x = map.get(ca[l]);
					map.put(ca[l], ++x);
					if (x > 0) {
						count++;
					}
				}
				l++;
				if (count == 0) {
					if (r - l < min) {
						subStr = s.substring(l, r);
						min = subStr.length();
					}
				}
			}
		}
		return subStr;
	}

}
