package com.lee.twopointers;

public class ValidPalindrome680 {

	public static void main(String[] args) {
		ValidPalindrome680 obj = new ValidPalindrome680();
		// System.out.println('A' + 0);
		// System.out.println('Z' + 0);
		// System.out.println('a' + 0);
		// System.out.println('z' + 0);
		System.out.println(obj.validPalindrome("abc"));
//		String s = "0123456";
//		System.out.println(s.charAt(s.length()-1));
//		System.out.println(s.substring(0, 6));
		// System.out.println(obj.isPalindrome("0P"));
	}

	int count = 1;
	public boolean validPalindrome(String s) {
		System.out.println(count + "...s " + s);
		

		s = s.toLowerCase();
		if (s == null) {
			return false;
		}
		if (s.length() == 0 && count == 1) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char a = s.charAt(i);
			char b = s.charAt(j);
			if (a != b) {
				if (count == 0) {
					return false;
				}
				count--;
				boolean ba = validPalindrome(s.substring(i + 1, j + 1));
				boolean bb = validPalindrome(s.substring(i, j));
				return (ba || bb);
			} else {
				i++;
				j--;
			}
		}
		return true;
	}
}
