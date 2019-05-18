package com.lee.again;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String s = x + "";
		if (s.length() == 1) {
			return true;
		}
		int left = 0;
		int right = s.length() - 1;
		char[] array = s.toCharArray();
		while (left <= right) {
			if (array[left] != array[right]) {
				return false;
			}
            left++;
            right--;
		}
		return true;
	}

}
