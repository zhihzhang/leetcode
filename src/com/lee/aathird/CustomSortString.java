package com.lee.aathird;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String customSortString(String S, String T) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : T.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (char c : S.toCharArray()) {
			int l = map.getOrDefault(c, 0);
			for (int i = 0; i < l; i++) {
				sb.append(c);
			}
			map.remove(c);
		}
		for (char k : map.keySet()) {
			for (int i = 0; i < map.get(k); i++) {
				sb.append(k);
			}
		}
		return sb.toString();
	}

}
