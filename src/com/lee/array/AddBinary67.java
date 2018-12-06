package com.lee.array;

public class AddBinary67 {

	public static void main(String[] args) {
		AddBinary67 obj = new AddBinary67();
		System.out.println(obj.addBinary("1010", "1011"));

	}

	public String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		int al = a.length();
		int bl = b.length();
		char[] ar = a.toCharArray();
		char[] br = b.toCharArray();
		int i = 1;
		StringBuilder sb = new StringBuilder();
		int preV = 0;
		while (i <= b.length()) {
			if (ar[al - i] == br[bl - i] && ar[al - i] == '1') {
				if (preV == 0) {
					sb.append("0");
					preV = 1;
				} else {
					sb.append("1");
				}
			} else if (ar[al - i] == br[bl - i] && ar[al - i] == '0') {
				if (preV == 0) {
					sb.append("0");
				} else {
					sb.append("1");
					preV = 0;
				}
			} else {
				if (preV == 0) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			}
			i++;
		}
		if (al == bl) {
			if (preV == 1) {
				sb.append("1");
			}
		} else {
			while (i <= al) {
				if (preV == 1) {
					if (ar[al - i] == '1') {
						sb.append('0');
					} else {
						sb.append('1');
						preV = 0;
					}
				} else {
					sb.append(ar[al - i]);
				}
				i++;
			}
			if (preV == 1) {
				sb.append('1');
			}
		}
		
		return sb.reverse().toString();
	}

}
