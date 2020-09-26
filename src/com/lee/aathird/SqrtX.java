package com.lee.aathird;

public class SqrtX {

	public static void main(String[] args) {
		SqrtX obj = new SqrtX();
		System.out.println(obj.mySqrt(8));

	}

	public int mySqrt(int x) {
		if (x < 2) {
			return x;
		}
		long l = 1;
		long r = x;
		while (l <= r) {
			long m = l + (r - l) / 2;
			if (m * m == x) {
				return (int)m;
			} else if (m * m > x) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return (int)r;
	}

}
