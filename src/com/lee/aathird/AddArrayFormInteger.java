package com.lee.aathird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrayFormInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for (int i = A.length - 1; i >= 0; i--) {
			a.add(A[i]);
		}
		while (K > 0) {
			int t = K % 10;
			b.add(t);
		}
		int i = 0;
		int t = 0;
		List<Integer> list = new ArrayList<>();
		while (i < a.size() && i < b.size()) {
			int n = a.get(i) + b.get(i) + t;
			list.add(n % 10);
			t = n / 10;
		}
		while (i < a.size()) {
			int n = a.get(i) + t;
			list.add(n % 10);
			t = n / 10;
		}
		while (i < b.size()) {
			int n = b.get(i) + t;
			list.add(n % 10);
			t = n / 10;
		}
		if (t > 0) {
			list.add(t);
		}
		Collections.reverse(list);
		return list;
	}

}
