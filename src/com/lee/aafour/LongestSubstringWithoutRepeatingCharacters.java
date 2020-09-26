package com.lee.aafour;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//"abcabcbb"
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int l = 0;
		int max = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(set.size(), max);
			} else {
				char t = s.charAt(l++);
				while (t != c) {
					set.remove(t);
					t = s.charAt(l++);
				}
				set.add(t);
			}
		}
		return max;
	}

}
