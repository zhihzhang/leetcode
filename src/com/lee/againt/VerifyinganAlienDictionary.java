package com.lee.againt;

public class VerifyinganAlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAlienSorted(String[] words, String order) {
		int[] ab = new int[26];
		int i = 0;
		for (Character c : order.toCharArray()) {
			ab[c - 'a'] = i;
			i++;
		}
		for (i = 0; i < words.length - 1; i++) {
			if (!compare(words[i], words[i + 1], ab)) {
				return false;
			}
		}
		return true;
	}

	public boolean compare(String a, String b, int[] ab) {
		int i = 0;
		int j = 0;
		while (i < a.length() && j < b.length()) {
			char c0 = a.charAt(i);
			char c1 = a.charAt(j);
			if (ab[c0 - 'a'] > ab[c1 - 'a']) {
				return false;
			}
		}
		if (a.length() > b.length()) {
			return false;
		}
		return true;
	}

}
