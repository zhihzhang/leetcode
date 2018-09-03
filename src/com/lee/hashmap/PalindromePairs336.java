package com.lee.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs336 {

	public static void main(String[] args) {
		PalindromePairs336 obj = new PalindromePairs336();
		System.out.println(obj.palindromePairs(new String[] { "abcd","dcba","lls","s","sssll" }));
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		String[] temp = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			StringBuilder sb = new StringBuilder(words[i]);
			temp[i] = sb.reverse().toString();
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i == j) {
					continue;
				}
				if (words[i].equals(temp[j])) {
					List<Integer> tl = new ArrayList<Integer>();
					tl.add(i);
					tl.add(j);
					list.add(tl);
					continue;
				}
				if (words[i].length() < temp[j].length()) {
					if (!temp[j].startsWith(words[i])) {
						continue;
					}
				} else {
					if (!words[i].startsWith(temp[j])) {
						continue;
					}
				}
				if (isPalindrome(words[i] + words[j])) {
					List<Integer> tl = new ArrayList<Integer>();
					tl.add(i);
					tl.add(j);
					list.add(tl);
				}
			}
		}
		return list;
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		int a = 0;
		int b = s.length() - 1;
		while (a < b) {
			if (s.charAt(a) != s.charAt(b)) {
				return false;
			}
			a++;
			b--;
		}
		return true;
	}

}
