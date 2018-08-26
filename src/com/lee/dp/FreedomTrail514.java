package com.lee.dp;

import java.util.Arrays;

public class FreedomTrail514 {
	public static void main(String[] args) {
		FreedomTrail514 obj = new FreedomTrail514();
		String ring = "";
		String key = "";
		ring = "godding";
		key = "gd";
		System.out.println("4...." + obj.findRotateSteps(ring, key));
		
		
		ring = "abcde";
		key = "ade";
		System.out.println("6...." + obj.findRotateSteps(ring, key));
		
		
		ring = "edcba";
		key = "abcde";
		System.out.println("10...." + obj.findRotateSteps(ring, key));
	}

	public int findRotateSteps(String ring, String key) {

		int ringSize = ring.length();
		int keySize = key.length();
		int[][] dp = new int[keySize][ringSize];
		for (int[] v : dp) {
			Arrays.fill(v, Integer.MAX_VALUE);
		}

		for (int i = 0; i < key.length(); i++) {
			char kc = key.charAt(i);
			for (int j = 0; j < ringSize; j++) {
				char rc = ring.charAt(j);
				if (kc == rc) {
					if (i == 0) {
						int steps = Math.min(j, ringSize - j);
						dp[i][j] = Math.min(dp[i][j], steps);
						System.out.println(i + "..b.." + j + "..." + steps);
					} else {
						for (int k = 0; k < ringSize; k++) {
							if (dp[i - 1][k] == Integer.MAX_VALUE) {
								continue;
							}
							int steps = Math.min(Math.abs(k - j), Math.abs(ringSize - Math.abs(k-j)));
							dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + steps);
							System.out.println(i + "...." + j + "..." + steps);
						}
					}
				}
			}
		}

		int steps = Integer.MAX_VALUE;
		for (int i = 0; i < ringSize; i++) {
			steps = Math.min(steps, dp[keySize - 1][i]);
		}
		return steps + keySize;
	}
}
