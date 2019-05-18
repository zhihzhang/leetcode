package com.lee.again;

public class Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}

		for (int i = 0; i < haystack.length() - needle.length(); i++) {
			int j = 0;
			while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}

}
