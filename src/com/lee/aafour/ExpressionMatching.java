package com.lee.aafour;

public class ExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) == '.' || p.charAt(j) == '*') {
				dp[0][j + 1] = true;
				continue;
			}
			if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
				dp[0][j + 1] = true;
				continue;
			}
			break;
		}

//		char pre = '123';
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = 0; j < p.length(); j++) {
//				if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
//					dp[i+1][j+1] = dp[i][j];
//				} else if (){
//					;
//				}
//			}
//		}
		return dp[s.length()][p.length()];
	}

}
