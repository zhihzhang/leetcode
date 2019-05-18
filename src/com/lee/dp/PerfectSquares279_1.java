package com.lee.dp;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares279_1 {

	public static void main(String[] args) {
		PerfectSquares279_1 obj = new PerfectSquares279_1();
		System.out.println(obj.numSquares(70));
	}
	
	Map<Integer, Integer> map = new HashMap<>();

	public int numSquares(int n) {
		if(map.containsKey(n)){
			return map.get(n);
		}
		int t = (int) Math.sqrt(n);
		if (t * t == n) {
			return 1;
		}

		int min = 1000;
		for (int i = t; i > 0; i--) {
			if (n < i * i) {
				continue;
			}
			int k = numSquares(n - i * i);
			min = Math.min(min, k + 1);
		}
		map.put(n, min);
		return min;
	}

}
