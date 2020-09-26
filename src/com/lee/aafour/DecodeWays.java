package com.lee.aafour;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		int v = s.charAt(0) - '0';
		if (v > 0) {
			dp[1] = 1;
		}
		dp[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			char a = s.charAt(i - 1);
			char b = s.charAt(i);
			int doubleV = (a - '0') * 10 + (b - '0');
			int singleV = b - '0';
			if (doubleV > 9 && doubleV <= 26 && singleV > 0) {
				dp[i + 1] = dp[i] + dp[i - 1];
			} else if (doubleV > 9 && doubleV <= 26) {
				dp[i + 1] = dp[i - 1];
			} else if (singleV > 0){
				dp[i + 1] = dp[i];
			}
		}
		return dp[s.length()];
	}

}
