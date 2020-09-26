package com.lee.aafour;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compress(char[] chars) {
		if (chars == null || chars.length == 0) {
			return 0;
		}
		if (chars.length == 1) {
			return 1;
		}
		int idx = 0;
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				count++;
			} else {
				chars[idx++] = chars[i - 1];
				if (count > 1) {
					String s = count + "";
					for (char w : s.toCharArray()) {
						chars[idx++] = w;
					}
				}
				count = 1;
			}
		}
		chars[idx++] = chars[chars.length-1];
		if (count > 1) {
			String s = count + "";
			for (char w : s.toCharArray()) {
				chars[idx++] = w;
			}
		}
		return idx;
	}

}
