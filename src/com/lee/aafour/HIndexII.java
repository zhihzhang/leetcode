package com.lee.aafour;

public class HIndexII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//0,1,3,5,6
	//3
	public int hIndex(int[] citations) {
		int len = citations.length;
		int l = 0;
		int r = len - 1;
		int n = 0;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (len - m <= citations[m]) {
				n = len - m;
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return n;
	}

}
