package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> map = new HashMap<>();

	public int numTrees(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if(map.containsKey(n)){
			return map.get(n);
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += numTrees(i - 1) * numTrees(n - i);
		}
		map.put(n, sum);
		return sum;
	}

}
