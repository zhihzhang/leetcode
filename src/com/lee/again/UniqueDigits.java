package com.lee.again;

import java.util.HashSet;
import java.util.Set;

public class UniqueDigits {

	public static void main(String[] args) {
		UniqueDigits obj = new UniqueDigits();
		System.out.println(obj.countNumbersWithUniqueDigits(3));
		System.out.println(obj.getNum(3));
		// 91      9*9 + 10;
		// 739     9*9*8 + 91;
		// 5275
	}

	// 50

	public int countNumbersWithUniqueDigits(int n) {
		if(n==0){
			return 1;
		}
		if(n==1){
			return 10;
		}
		int[] dp = new int[n + 1];
		dp[1] = 10;
		int factor = 9;
		int prep = 9;
		for (int i = 2; i <= n; i++) {
			prep = prep * factor;
			factor--;
			dp[i] = dp[i-1] + prep;
		}
		return dp[n];
	}

	public int getNum(int n) {
		int total = (int) Math.pow(10, n);
		int count = 0;
		for (int i = 0; i < total; i++) {
			String s = i + "";
			Set<Character> set = new HashSet<>();
			char[] a = s.toCharArray();
			for (char c : a) {
				set.add(c);
			}
			if (set.size() == a.length) {
				count++;
			}
		}
		return count;
	}

}
