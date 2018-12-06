package com.lee.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxPairChain646 {

	public static void main(String[] args) {
		MaxPairChain646 obj = new MaxPairChain646();
//		{
//			int[][] x = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
//			int t = obj.findLongestChain(x);
//			System.out.println(".........result = " + t);
//		}
		{
		int[][] x = new int[][] { {7,9},{4,5},{7,9},{-7,-1},{0,10},{3,10},{3,6},{2,3} };
		int t = obj.findLongestChain(x);
		System.out.println(".........result = " + t);
		}
	}
	
	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0) {
			return 0;
		}
		if (pairs.length == 1) {
			return 1;
		}
		List<int[]> list = new ArrayList<int[]>();
		for (int[] a : pairs) {
			list.add(a);
		}
		Collections.sort(list, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
			}
		});
		
//		for (int i = 0; i < list.size(); i++) {
//			int[] a = list.get(i);
//			System.out.println(Arrays.toString(a));
//		}

		int[] dp = new int[pairs.length];
		dp[0] = 1;
		int dpMax = 1;
		for (int i = 1; i < list.size(); i++) {
			int[] a = list.get(i);
			int max = 1;
			for (int j = 0; j < i; j++) {
				int[] b = list.get(j);
				if (b[1] < a[0]) {
					max = Math.max(dp[j] + 1, max);
				}
			}
			dp[i] = max;
			dpMax = Math.max(dpMax, max);
		}
		return dpMax;
	}

}
