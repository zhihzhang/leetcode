package com.lee.aathird;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {
		String t = strs[0];
		for (int i = 1; i < strs.length; i++) {
			t = getC(t, strs[i]);
			if (t.length() == 0) {
				return "";
			}
		}
		return t;
	}

	public String getC(String t, String s) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < t.length() && i < s.length(); i++) {
			if (t.charAt(i) == s.charAt(i)) {
				sb.append(t.charAt(i));
			}
		}
		return sb.toString();
	}

}
