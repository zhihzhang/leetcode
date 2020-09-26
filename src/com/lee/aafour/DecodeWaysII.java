package com.lee.aafour;

import java.util.Arrays;

public class DecodeWaysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = '*' - '0';
		System.out.println(v);
		
		DecodeWaysII obj = new DecodeWaysII();
//		System.out.println(obj.numDecodings("*1*1*0"));
		System.out.println(obj.numDecodings("1*72*"));
		System.out.println(obj.numDecodings2("1*72*"));
	}

	int M = 1000000007;
	public int numDecodings(String s) {
		// int v = '*'-'0';
		// System.out.println(v);
		if (s == null || s.length() == 0) {
			return 0;
		}
		long[] dp = new long[s.length() + 1];
		int v = s.charAt(0) - '0';
		if (v > 0) {
			dp[1] = 1;
		} else if (v == -6) {
			dp[1] = 9;
		}
		dp[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			char a = s.charAt(i - 1);
			char b = s.charAt(i);
			int doubleV = a - '0';
			int singleV = b - '0';
			if (singleV == 0) {
				if (doubleV == 0 || doubleV > 2) {
					dp[i+1] = 0;
				} else if (doubleV == -6){
					dp[i+1] = dp[i - 1] * 2;
				} else {
					dp[i+1] = dp[i - 1];
				}
			} else if (doubleV == 0){
				if (singleV == -6) {
					dp[i + 1] = dp[i]*9;
				} else {
					dp[i + 1] = dp[i];
				}
			} else if (doubleV != -6 && singleV != -6) {
				int total = doubleV * 10 + singleV;
				if (total > 9 && total <= 26 && singleV > 0) {
					dp[i + 1] = dp[i] + dp[i - 1];
				} else if (total > 9 && total <= 26) {
					dp[i + 1] = dp[i - 1];
				} else if (singleV > 0) {
					dp[i + 1] = dp[i];
				}
			} else if (doubleV == -6 && singleV == -6) {
				dp[i + 1] = dp[i] * 9 + dp[i - 1] * 15;
			} else if (doubleV == -6) {
				if (singleV > 6) {
					dp[i + 1] = dp[i];
				} else {
					dp[i + 1] = dp[i] + dp[i - 1] * 2;
				}
			} else if (singleV == -6) {
				if (doubleV > 2) {
					dp[i + 1] = dp[i] * 9;
				} else if (doubleV == 2) {
					dp[i + 1] = dp[i] * 9 + dp[i - 1] * 6;
				} else {
					dp[i + 1] = dp[i] * 9 + dp[i - 1] * 9;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return (int)dp[s.length()]%M;
	}
	
    
    public int numDecodings2(String s) {
        long first = 1, second = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            long temp = second;
            if (s.charAt(i) == '*') {
                second = 9 * second;
                if (s.charAt(i - 1) == '1')
                    second = (second + 9 * first) % M;
                else if (s.charAt(i - 1) == '2')
                    second = (second + 6 * first) % M;
                else if (s.charAt(i - 1) == '*')
                    second = (second + 15 * first) % M;
            } else {
                second = s.charAt(i) != '0' ? second : 0;
                if (s.charAt(i - 1) == '1')
                    second = (second + first) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    second = (second + first) % M;
                else if (s.charAt(i - 1) == '*')
                    second = (second + (s.charAt(i) <= '6' ? 2 : 1) * first) % M;
            }
            first = temp;
            System.out.println(second);
        }
        return (int) second;
    }

}
