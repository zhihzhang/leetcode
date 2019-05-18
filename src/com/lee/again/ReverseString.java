package com.lee.again;

public class ReverseString {

	public static void main(String[] args) {

	}

	public void reverseString(char[] s) {
		int l = 0;
		int r = s.length - 1;
		while (l < r) {
			char c = s[l];
			s[l] = s[r];
			s[r] = c;
			r--;
			l++;
		}
	}

}
