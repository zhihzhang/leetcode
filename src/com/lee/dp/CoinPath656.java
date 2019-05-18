package com.lee.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoinPath656 {

	public static void main(String[] args) {
		CoinPath656 obj = new CoinPath656();
		int[] A= new int[]{1,2,4,-1,2};
		System.out.println(Arrays.toString(obj.cheapestJump(A, 2).toArray()));
	}
	
	public List<Integer> cheapestJump(int[] A, int B) {
		int n = A.length;
		int[] dp = new int[n];
		int[] decisions = new int[n];
		dp[n - 1] = A[n - 1];
		decisions[n - 1] = (A[n - 1] == -1 ? -2 : -1);
		for (int i = n - 2; i >= 0; i--) {
			int value = Integer.MAX_VALUE;
			int index = -2;
			for (int j = i + 1; j < Math.min(n, i + B + 1); j++) {
				if (dp[j] < value && decisions[j] != -2) {
					value = dp[j];
					index = j;
				}
			}
			dp[i] = A[i] + value;
			decisions[i] = (A[i] == -1 ? -2 : index);
			System.out.println(i + "   " + dp[i] + "   " + decisions[i]);
		}

		// Construct Path
		List<Integer> res = new LinkedList<>();
		if (decisions[0] == -2){
			return res;
		}
		int k = 0;
		while (k != -1) {
			res.add(k + 1);
			k = decisions[k];
		}

		return res;
	}

//	public List<Integer> cheapestJump(int[] A, int B) {
//		int[] dp = new int[A.length];
//		Map<Integer, Integer> path = new HashMap<>();
//		List<Integer> list = new ArrayList<>();
//
//		if (A.length == 1) {
//			list.add(0);
//			return list;
//		}
//		Arrays.fill(dp, Integer.MAX_VALUE);
//		dp[0] = A[0];
//		for (int i = 1; i < A.length; i++) {
//			for(int j=1;j<=B;j++){
//				dp[i+j] = Math.min(dp[i+j], dp[i] + A[i]);
//			}
//		}
//		return list;
//
//	}

}
