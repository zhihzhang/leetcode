package com.lee.againt;

public class InterleavingString {

	public static void main(String[] args) {
		InterleavingString obj = new InterleavingString();
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		System.out.println(obj.isInterleave(s1, s2, s3));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i > 0 && s1.charAt(i-1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
					dp[i][j] = true;
				} else if (j > 0 && s2.charAt(j-1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
					dp[i][j] = true;
				} 
			}
		}
		return dp[s1.length()][s2.length()];
	}

}
