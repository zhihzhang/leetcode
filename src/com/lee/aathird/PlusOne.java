package com.lee.aathird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int[] digits) {
		List<Integer> list = new ArrayList<>();
		int t = 0;
		for (int i = digits.length - 1; i >= 0; i++) {
			int v = t + digits[i] + 1;
			list.add(v % 10);
			t = v / 10;
		}
		if (t > 0) {
			list.add(t);
		}
		int[] a = new int[list.size()];
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
		return a;
	}

}
