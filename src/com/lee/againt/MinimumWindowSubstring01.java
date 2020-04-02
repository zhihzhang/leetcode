package com.lee.againt;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring01 {

	public static void main(String[] args) {
		MinimumWindowSubstring01 obj = new MinimumWindowSubstring01();
		System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));

	}

	// Input: S = "ADOBECODEBANC", T = "ABC"
	// Output: "BANC"
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		int l = 0;
		int r = 0;
		String rStr = "";
		while (r < s.length()) {
			while (r < s.length()) {
				if (map.containsKey(s.charAt(r))) {
					int num = map.get(s.charAt(r));
					num--;
					map.put(s.charAt(r), num);
					if (num == 0) {
						counter--;
					}
				}
				if (counter == 0) {
					if (r - l + 1 < rStr.length() || rStr.length() == 0) {
						rStr = s.substring(l, r + 1);
					}
					break;
				}
				r++;
			}
			while (l <= r) {
				if (map.containsKey(s.charAt(l))) {
					int num = map.get(s.charAt(l));
					num++;
					map.put(s.charAt(l), num);
					if (num == 1) {
						counter++;
					}
				}
				l++;
				if (counter == 0) {
					if (r - l + 1 < rStr.length()) {
						rStr = s.substring(l, r + 1);
					}
				} else if (counter > 0) {
					break;
				}
			}
			r++;
		}
		return rStr;

	}

}
