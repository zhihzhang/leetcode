package com.lee.aathird;

public class AddString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//   678
	// 22567

	public String addStrings(String num1, String num2) {
		char[] a = new StringBuilder(num1).reverse().toString().toCharArray();
		char[] b = new StringBuilder(num2).reverse().toString().toCharArray();
		int i = 0;
		int n = 0;
		StringBuilder sb = new StringBuilder();
		while (i < a.length && i < b.length) {
			int x = a[i] - '0';
			int y = b[i] - '0';
			int z = x + y + n;
			n = z / 10;
			sb.append(z % 10);
			i++;
		}
		while (i < a.length) {
			int x = a[i] - '0';
			int z = x + n;
			n = z / 10;
			sb.append(z % 10);
		}
		while (i < b.length) {
			int y = b[i] - '0';
			int z = y + n;
			n = z / 10;
			sb.append(z % 10);
		}
		if(n>0){
			sb.append(n);
		}
		return sb.reverse().toString();
	}

}
