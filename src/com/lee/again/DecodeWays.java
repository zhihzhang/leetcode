package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "1234567890";
//		System.out.println(s.substring(0,2));
//		System.out.println(s.substring(1,2));
		for (int i = 2; i < s.length(); i++) {
			String t = s.substring(i - 1, i+1);
			System.out.println(i + "...." + t);
		}
		DecodeWays obj = new DecodeWays();
		System.out.println(obj.numDecodings("22"));
		System.out.println(obj.numDecodings("226"));
		System.out.println(obj.numDecodings("0"));
		System.out.println(obj.numDecodings("10"));
		System.out.println(obj.numDecodings("100"));

	}

	String[] keys = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26" };

	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		Map<String, Integer> map = new HashMap<>();
		for (String v : keys) {
			map.put(v, 1);
		}

		int[] dp = new int[s.length()];
		dp[0] = map.getOrDefault(s.substring(0, 1), 0);
		if (dp.length == 1) {
			return dp[0];
		}
		
		
		if(map.containsKey(s.substring(1, 2))){
			dp[1] = dp[1] + dp[0];
		}
		if(map.containsKey(s.substring(0, 2))){
			dp[1] = dp[1] + 1;
		}
//		dp[1] = Math.min(map.getOrDefault(s.substring(1, 2), 0), dp[0]) + map.getOrDefault(s.substring(0, 2), 0);

		for (int i = 2; i < s.length(); i++) {
//			dp[i] = Math.min(map.getOrDefault(s.substring(i - 1), 0), dp[i - 1])
//					+ Math.min(map.getOrDefault(s.substring(i - 2), 0), dp[i - 2]);
			
			if(map.containsKey(s.substring(i, i+1))){
				dp[i] = dp[i] + dp[i-1];
			}
			if(map.containsKey(s.substring(i-1, i+1))){
				dp[i] = dp[i] + dp[i-2];
			}
		}

		return dp[s.length() - 1];
	}

}
