package com.lee.aathird;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//16 14
	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		long r = num;
		long l = 1;
		while (l <= r) {
			long m = l + (r - l) / 2;
			if (m * m == num) {
				return true;
			} else if (m * m < num) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return false;
	}

}
