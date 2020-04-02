package com.lee.againt;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		PalindromicSubstrings obj = new PalindromicSubstrings();
		System.out.println(obj.countSubstrings("aaa"));

	}
	
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}

		char[] array = s.toCharArray();
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		int count = s.length();
		System.out.println(count + "....");
		for (int i = 0; i < s.length() - 1; i++) {
			if (array[i] == array[i + 1]) {
				dp[i][i + 1] = 1;
				count++;
			}
		}
		System.out.println(count + "....");
		for (int l = 2; l < s.length(); l++) {
			for (int i = 0; i + l < s.length(); i++) {
				if (array[i] == array[i + l] && dp[i+1][i+l-1]==1) {
					dp[i][i+l]=1;
					count++;
				}
			}
		}
		return count;
	}

}
