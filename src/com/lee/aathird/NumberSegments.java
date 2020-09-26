package com.lee.aathird;

public class NumberSegments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSegments(String s) {
		if (s == null) {
			return 0;
		}
		boolean flag = true;
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				flag = true;
			} else if (flag) {
				count++;
				flag = false;
			}
		}
		return count;
	}

}
