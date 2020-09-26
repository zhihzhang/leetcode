package com.lee.aafour;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		System.out.println(obj.longestPalindromeSubseq("bbbab"));
		System.out.println(obj.longestPalindromeSubseq("cbbn"));

	}

	public int longestPalindromeSubseq(String s) {
		int l = s.length();
		int[][] dp = new int[l][l];
		for (int i = 0; i < l; i++) {
			dp[i][i] = 1;
		}
		for (int k = 1; k < l; k++) { // length
			for (int i = 0; i + k < l; i++) {
				if (s.charAt(i) == s.charAt(i + k)) {
					dp[i][i + k] = dp[i + 1][i + k - 1] + 2;
				} else {
					dp[i][i + k] = Math.max(dp[i + 1][i + k], dp[i][i + k - 1]);
				}
			}
		}
		return dp[0][l - 1];
	}

}
