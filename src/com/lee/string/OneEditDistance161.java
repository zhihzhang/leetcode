package com.lee.string;

public class OneEditDistance161 {

	public static void main(String[] args) {
		OneEditDistance161 obj = new OneEditDistance161();
		System.out.println(obj.isOneEditDistance("a", "ac"));
	}

	public boolean isOneEditDistance(String s, String t) {
		if (s.length() == t.length()) {
			int c = getDiff(s, t);
			return c == 1 ? true : false;
		}
		int a = s.length();
		int b = t.length();
		if (Math.abs(a - b) != 1) {
			return false;
		}
		String x = null;
		String y = null;
		if (a > b) {
			x = s;
			y = t;
		} else {
			x = t;
			y = s;
		}

		if (y.length() == 0 && x.length() == 1) {
			return true;
		}

		int count = 0;
		a = 0;
		b = 0;
		while (true) {

			if (x.charAt(a) == y.charAt(b)) {
				a++;
				b++;
			} else {
				a++;
				count++;
			}
			if (count > 1) {
				return false;
			}
			if (a >= x.length()) {
				break;
			}
			if (b == y.length() && count == 0) {
				return true;
			}
		}
		return count == 1 ? true : false;
	}

	public int getDiff(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				count++;
			}
		}
		return count;
	}

}
