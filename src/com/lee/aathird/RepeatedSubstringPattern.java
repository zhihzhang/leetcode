package com.lee.aathird;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		RepeatedSubstringPattern obj = new RepeatedSubstringPattern();
		// System.out.println(obj.repeatedSubstringPattern("abcabc"))
		System.out.println(obj.repeatedSubstringPattern("ababab"));

	}

	public boolean repeatedSubstringPattern(String s) {
		int le = s.length();
		int h = le / 2;
		for (int i = h; i > 1; i--) {
			if (le % i == 0) {
				boolean flag = check(s, i, le / i);
				if (flag) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean check(String s, int i, int k) {
		String w = s.substring(0, i);
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < k; j++) {
			sb.append(w);
		}
		return s.equals(sb.toString());
	}

}
