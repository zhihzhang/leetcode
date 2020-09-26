package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings obj = new IsomorphicStrings();
		System.out.println(obj.isIsomorphic("abbbc", "gttwd"));

	}

	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> a = new HashMap<>();
		Map<Character, Integer> b = new HashMap<>();
		List<Integer> list01 = new ArrayList<>();
		List<Integer> list02 = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (a.containsKey(c)) {
				list01.add(a.get(c));
			} else {
				a.put(c, i);
				list01.add(i);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (b.containsKey(c)) {
				list02.add(b.get(c));
			} else {
				b.put(c, i);
				list02.add(i);
			}
		}
		return list01.toString().equals(list02.toString());
	}

}
