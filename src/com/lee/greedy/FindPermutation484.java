package com.lee.greedy;

import java.util.Arrays;

public class FindPermutation484 {

	public static void main(String[] args) {
		FindPermutation484 obj = new FindPermutation484();
		System.out.println(Arrays.toString(obj.findPermutation("DDIIDI")));

	}

	public int[] findPermutation(String s) {
		int[] res = new int[s.length() + 1];
		res[0] = 1;
		int i = 1;
		while (i <= s.length()) {
			res[i] = i + 1;
			int j = i;
			if (s.charAt(i - 1) == 'D') {
				while (i <= s.length() && s.charAt(i - 1) == 'D') {
					i++;
				}
				for (int k = j - 1, c = i; k <= i - 1; k++, c--) {
					res[k] = c;
				}
			} else {
				i++;
			}
		}
		return res;
	}

	// public int[] findPermutation(String s) {
	// int min = Integer.MAX_VALUE;
	// int[] a = new int[s.length() + 1];
	// int v = 1;
	// a[0] = v;
	// int i = 1;
	//
	// for (char c : s.toCharArray()) {
	// if (c == 'D') {
	// a[i] = v - 1;
	// } else {
	// a[i] = v + 1;
	// }
	// min = Math.min(a[i], min);
	// i++;
	// }
	// System.out.println(Arrays.toString(a) + "___" + min);
	// int t = -min;
	// t = t + 1;
	// for (int j = 0; j < a.length; j++) {
	// a[j] = a[j] + t;
	// }
	// return a;
	// }

}
