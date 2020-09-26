package com.lee.aathird;

public class MaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximum69Number(int num) {
		String s = num + "";
		int i = s.indexOf('6');
		int j = s.indexOf('9', i);
		if (j > i) {
			char[] a = s.toCharArray();
			a[i] = '9';
			a[j] = '6';
			StringBuilder sb = new StringBuilder();
			sb.append(a);
			int v = Integer.valueOf(sb.toString());
			return v;
		} else {
			return num;
		}
	}

}
