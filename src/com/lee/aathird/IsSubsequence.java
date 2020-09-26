package com.lee.aathird;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("a", 1);
		System.out.println(map);
		
		map = null;
		System.out.println(map);
	}

	public boolean isSubsequence(String s, String t) {
		int i = 0;
		int j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		if (i < s.length()) {
			return false;
		}
		return true;
	}

}
