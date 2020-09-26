package com.lee.aathird;

public class RepeatedStringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int repeatedStringMatch(String A, String B) {
		if (A.contains(B)) {
			return 1;
		}
		int s1 = A.length();
		int s2 = B.length();
		int k = s2 / s1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k + 2; i++) {
			sb.append(A);
			if (sb.length() > B.length() && sb.toString().contains(B)) {
				return i + 1;
			}
		}
		return -1;
	}

}
