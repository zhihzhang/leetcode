package com.lee.aathird;

public class BinaryNumberAlternatingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasAlternatingBits(int n) {
		int count = Integer.bitCount(n);
		int pre = -1;
		for (int i = 0; i < 32 && count > 0; i++) {
			int t = (n >> i) & 1;
			if (t == 1) {
				count--;
			}
			if (pre + t == 1) {
				pre = t;
				continue;
			}
			return false;
		}
		return true;
	}

}
