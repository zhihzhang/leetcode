package com.lee.aathird;

public class SumSquareNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean judgeSquareSum(int c) {
		if(c<2){
			return true;
		}
		for (long i = 0; i < c; i++) {
			long n = i * i;
			if (n > c) {
				break;
			} else if (n == c) {
				return true;
			} else if (n < c) {
				if (check(c-(int)n)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean check(int c) {
		int t = (int) Math.sqrt(c);
		if (t * t == c) {
			return true;
		}
		return false;
	}

}
