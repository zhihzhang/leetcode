package com.lee.aathird;

public class FirstBadVersion {

	public static void main(String[] args) {
		FirstBadVersion obj = new FirstBadVersion();
		int n = obj.firstBadVersion(2126753390);
		System.out.println(n);

	}

	public int firstBadVersion(int n) {
		int l = 1;
		int r = n;
		while (l <= r) {
			int m = l + (r-l)/ 2;
			if (isBadVersion(m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

	boolean isBadVersion(int version) {
		if (version >= 1702766719) {
			return true;
		}
		return false;
	}

}
