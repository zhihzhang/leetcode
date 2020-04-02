package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	public static void main(String[] args) {
		PalindromePairs obj = new PalindromePairs();
		String[] words = new String[] { "abcd", "dcba", "lls", "s", "sssll" };
		List<List<Integer>> r = obj.palindromePairs(words);
		System.out.println(r.toString());
	}

	// ["abcd","dcba","lls","s","sssll"]
	// aaaabc cba
	// 123aa 321
	// a ""
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		Map<String, String> reverseMap = new HashMap<>();
		Map<String, Integer> indexMap = new HashMap<>();
		int i = 0;
		for (String s : words) {
			StringBuilder sb = new StringBuilder(s);
			reverseMap.put(s, sb.reverse().toString());
			indexMap.put(s, i++);
		}

		for (i = 0; i < words.length; i++) {
			if (words[i].equals("")) {
				for (int j = 0; j < words.length; j++) {
					if (isPalidromeString(words[j]) && i != j) {
						List<Integer> list = new ArrayList<>();
						list.add(i);
						list.add(j);
						result.add(list);
					}
				}
				continue;
			}
			String x = reverseMap.get(words[i]);
			for (int j = 1; j <= x.length(); j++) {
				String t = x.substring(j, x.length());
				String d = x.substring(0, j);
				if (reverseMap.containsKey(t) && isPalidromeString(d) && i != indexMap.get(t)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(indexMap.get(t));
					result.add(list);
				}
				if (reverseMap.containsKey(d) && isPalidromeString(t) && i != indexMap.get(d)) {
					List<Integer> list = new ArrayList<>();
					list.add(indexMap.get(d));
					list.add(i);
					result.add(list);
				}
			}
		}
		return result;
	}

	public boolean isPalidromeString(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		int l = 0, r = s.length() - 1;
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

}
