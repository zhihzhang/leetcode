package com.lee.twopointers;

public class ValidPalindrome125 {

	public static void main(String[] args) {
		ValidPalindrome125 obj = new ValidPalindrome125();
		// System.out.println('A' + 0);
		// System.out.println('Z' + 0);
		// System.out.println('a' + 0);
		// System.out.println('z' + 0);
		System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(obj.isPalindrome("0P"));
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		if (s == null) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char a = s.charAt(i);
			if (!Character.isLetterOrDigit(a)) {
				i++;
				continue;
			}
			char b = s.charAt(j);
			if (!Character.isLetterOrDigit(b)) {
				j--;
				continue;
			}
			if (a != b) {
//				 System.out.println(a + " " + b + " num " + i + ":" + j);
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

}
