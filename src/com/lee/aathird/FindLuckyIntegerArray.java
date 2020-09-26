package com.lee.aathird;

import java.util.Arrays;

public class FindLuckyIntegerArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLucky(int[] arr) {
		Arrays.sort(arr);
		int pre = -1;
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int n = arr[i];
			if (n == pre) {
				count++;
			} else {
				if (pre == count) {
					return pre;
				}
				pre = n;
				count = 1;
			}
		}
		return -1;
	}

}
