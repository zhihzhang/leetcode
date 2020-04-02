package com.lee.again;

import java.util.Arrays;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		PalindromicSubstrings obj = new PalindromicSubstrings();
		System.out.println(obj.countSubstrings("aaaaa"));
	}

	public int countSubstrings(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			count++;
		}
//		System.out.println("....count " + count);

		for (int i = 1; i < n; i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				dp[i - 1][i] = 1;
				count++;
			}
		}
//		System.out.println("....count " + count);
		for (int k = 2; k < n; k++) {
			for (int i = 0; i + k < n; i++) {
				int j = i + k;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					count++;
				}
			}
		}
//		System.out.println("....count " + Arrays.toString(dp[0]));
//		System.out.println("....count " + Arrays.toString(dp[1]));
//		System.out.println("....count " + Arrays.toString(dp[2]));
//		System.out.println("....count " + Arrays.toString(dp[3]));
//		System.out.println("....count " + Arrays.toString(dp[4]));
		return count;
	}

}
