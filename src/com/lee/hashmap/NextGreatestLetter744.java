package com.lee.hashmap;

public class NextGreatestLetter744 {

	public static void main(String[] args) {
		NextGreatestLetter744 obj = new NextGreatestLetter744();
		System.out.println('a' - 0);
		char x = obj.nextGreatestLetter(new char[] { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' }, 'e');
		System.out.println(x);
	}

	public char nextGreatestLetter(char[] letters, char target) {
		int left = 0;
		int right = letters.length - 1;

		if (letters[0] > target) {
			return letters[0];
		}

		if (target >= letters[letters.length - 1]) {
			return letters[0];
		}

		while (left <= right) {
			int mid = (right - left) / 2 + left + 1;
			char b = letters[mid];
			char a = letters[mid - 1];
			if ((b - target > 0 && a <= target) || (target == 'z' && a <= target && b >= 'a')) {
				return letters[mid];
			} else if (b <= target) {
				left = mid;
			} else if (a > target) {
				right = mid - 1;
			}
		}
		return letters[0];

	}

}
