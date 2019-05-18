package com.lee.again;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String x = obj.longestPalindrome("aabbccrddcdc");
		System.out.println(x);
	}

	public String longestPalindrome(String s) {
		int n = s.length();
		if(n==0){
			return s;
		}
		int[][] dp = new int[n][n];
		int max = 1;
		int a = 0;
		int b = 0;
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				max = 2;
				a = i;
				b = i + 1;
			}
		}
		for (int t = 2; t < s.length(); t++) {
			for (int i = 0; i < s.length() - t; i++) {
				int j = i + t;
				if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 1;
					if (j - i + 1 > max) {
						max = j - i + 1;
						a = i;
						b = j;
					}
				}
			}
		}
		System.out.println(a + "..." + b);
		return s.substring(a, b + 1);
	}

}
