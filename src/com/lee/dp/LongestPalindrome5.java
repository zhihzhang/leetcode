package com.lee.dp;

public class LongestPalindrome5 {

	public static void main(String[] args) {
		String x = "iakdjsa..kldlk...fiohasoifhjjkdyslneu";
		String y = longestPalindrome(x);
		System.out.println(x + "------------" + y);

	}
	
	public static String longestPalindrome(String s) {
		  int n = s.length();
		  String res = null;
		    
		  boolean[][] dp = new boolean[n][n];
		    
		  for (int i = n - 1; i >= 0; i--) {
		    for (int j = i; j < n; j++) {
		      dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i < 3) || dp[i + 1][j - 1]);
		            
		      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
		        res = s.substring(i, j + 1);
		      }
		    }
		  }
		    
		  return res;
		}

}
