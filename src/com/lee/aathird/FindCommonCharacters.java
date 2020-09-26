package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> commonChars(String[] A) {
		List<String> list = new ArrayList<>();
		int[] a = new int[26];
		for (char c : A[0].toCharArray()) {
			a[c - 'a']++;
		}
		for (int i = 0; i < A.length; i++) {
			String s = A[i];
			int[] b = new int[26];
			for (char c : s.toCharArray()) {
				b[c - 'a']++;
			}
			for (int j = 0; j < a.length; j++) {
				a[j] = Math.min(a[j], b[j]);
			}
		}
		for (int i = 0; i < a.length; i++) {
			char c = (char) ('a' + i);
			int v = a[i];
			for (int j = 0; j < v; j++) {
				list.add(c + "");
			}
		}
		return list;
	}

}
