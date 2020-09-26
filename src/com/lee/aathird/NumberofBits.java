package com.lee.aathird;

public class NumberofBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			count += (n >> i) & 1;
		}
		return count;
	}

}
