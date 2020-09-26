package com.lee.againt;

public class ExpressiveWords {

	public static void main(String[] args) {
		ExpressiveWords obj = new ExpressiveWords();
		String S = "heeellooo";
		String[] words = { "hello", "hi", "helo" };
		System.out.println(obj.expressiveWords(S, words));
	}

	// S = "heeellooo"
	// words = ["hello", "hi", "helo"]

	public int expressiveWords(String S, String[] words) {
		int count = 0;
		for (String w : words) {
			count += compare(S, w);
		}
		return count;
	}

	public int compare(String a, String w) {
		int i = 0;
		int j = 0;
		while (i < a.length() && j < w.length()) {
			char x = a.charAt(i);
			char y = w.charAt(j);
			if (x != y) {
				return 0;
			}
			int c0 = 1;
			int c1 = 1;
			i++;
			j++;
			while (i < a.length() && a.charAt(i) == x) {
				c0++;
				i++;
			}
			while (j < w.length() && w.charAt(j) == y) {
				c1++;
				j++;
			}
			if (c0 == c1 || (c0 > c1 && c0 >= 3)) {
				continue;
			}
			return 0;
		}
		if (i >= a.length() && j >= w.length()) {
			return 1;
		}
		return 0;
	}

}
