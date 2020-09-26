package com.lee.aafour;

public class ExpressiveWords {

	public static void main(String[] args) {
		ExpressiveWords obj = new ExpressiveWords();
		System.out.println(obj.compare("", ""));

	}

	public int expressiveWords(String S, String[] words) {
		int count = 0;
		for (String w : words) {
			if (compare(S, w)) {
				count++;
			}
		}
		return count;
	}

	public boolean compare(String a, String w) {
		int i = 0;
		int j = 0;
		while (i < a.length() && j < w.length()) {

			char c0 = a.charAt(i);
			char c1 = w.charAt(j);
			if (c0 != c1) {
				return false;
			}
			int ac = 0;
			while (c0 == a.charAt(i) && i < a.length()) {
				ac++;
				i++;
			}

			int wc = 0;
			while (c1 == w.charAt(j) && j < w.length()) {
				wc++;
				j++;
			}

			if (!(ac == wc || (ac>=3 && ac>wc))) {
				return false;
			}
		}
		if (!(i < a.length() || j < w.length())) {
			return false;
		}
		return true;
	}

}
