package com.lee.aathird;

public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int reverseBits(int n) {
		int r = 0;
		for (int i = 0; i < 31; i++) {
			int t = (n >> 1) & 1;
			r = r << 1;
			r = r | t;
		}
		return r;
	}

}
