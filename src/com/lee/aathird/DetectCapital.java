package com.lee.aathird;

public class DetectCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean detectCapitalUse(String word) {
		char c = word.charAt(0);
		if (c >= 'a' && c <= 'z') {
			return allLow(word);
		} else {
			return allLow(word) || allUpper(word);
		}
	}

	public boolean allLow(String word) {
		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				return false;
			}
		}
		return true;
	}

	public boolean allUpper(String word) {
		for (int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c >= 'a' && c <= 'z') {
				return false;
			}
		}
		return true;
	}

}
