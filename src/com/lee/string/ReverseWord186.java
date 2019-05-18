package com.lee.string;

public class ReverseWord186 {

	public static void main(String[] args) {
		ReverseWord186 obj = new ReverseWord186();

	}

	public void reverseWords(char[] str) {
		int left = 0;
		int right = str.length - 1;
		while (left < right) {
			int i = left;
			while (str[i] != ' ' && i < str.length) {
				i++;
			}
			int j = right;
			while (str[j] != ' ' && j > -1) {
				j--;
			}

			if (j < i) {
				return;
			}
			if (i - left <= right - j) {
				while (left < i) {
					swap(left++, right++, str);
				}
			} else {
				while (right > i) {
					swap(left++, right++, str);
				}
			}

		}
	}

	public void swap(int i, int j, char[] str) {
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
	}

}
