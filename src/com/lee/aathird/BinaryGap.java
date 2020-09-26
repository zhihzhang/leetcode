package com.lee.aathird;

public class BinaryGap {

	public static void main(String[] args) {
		BinaryGap obj = new BinaryGap();
		System.out.println(obj.binaryGap(5));

	}

	public int binaryGap(int N) {
		int pre = -1;
		int max = 0;
		for (int i = 0; i < 32; i++) {
			int t = (N >> i) & 1;
			if (t == 1 && pre > -1) {
				max = Math.max(max, i - pre);
				pre = i;
			} else if (t == 1) {
				pre = i;
			}
		}
		return max;
	}

}
