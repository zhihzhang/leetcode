package com.lee.aathird;

public class PowerofTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfTwo(int n) {
		int t = n | (n - 1);
		return t == 0;
	}

}
