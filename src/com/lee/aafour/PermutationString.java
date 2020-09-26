package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkInclusion(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int k = s1.length();
		int i = 0;
		while (i + k < s2.length()) {
			int v = isPu(map, k, i, s2);
			if (v == -1) {
				return true;
			}
			i = v + 1;
		}
		return false;
	}

	public int isPu(Map<Character, Integer> t, int l, int s, String s2) {
		Map<Character, Integer> map = new HashMap<>(t);
		for (int i = s; i < s + l; i++) {
			char c = s2.charAt(i);
			if (!map.containsKey(c)) {
				return i;
			}
			if (map.get(c) == 0) {
				return s;
			}
			map.put(c, map.get(c) - 1);
		}
		return -1;
	}

}
