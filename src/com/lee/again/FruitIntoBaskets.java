package com.lee.again;

import java.util.Map;
import java.util.TreeMap;

public class FruitIntoBaskets {

	public static void main(String[] args) {
		FruitIntoBaskets obj = new FruitIntoBaskets();
		
		int[] tree = new int[]{3,3,3,1,2,1,1,2,3,3,4};
		int t = obj.totalFruit(tree);
		System.out.println(t);
	}
	
	public int totalFruit(int[] tree) {
		int max = 0;
		int start = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < tree.length; i++) {
			int c = tree[i];
			if (map.containsKey(c)) {
				map.put(c, i);
				max = Math.max(max, i - start + 1);
			} else {
				if (map.size() == 2) {
					int t = c;
					int min = Integer.MAX_VALUE;
					for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
						if (entry.getValue() < min) {
							min = entry.getValue();
							t = entry.getKey();
						}
					}
					map.remove(t);
					start = min + 1;
					map.put(c, i);
				} else {
					map.put(c, i);
					max = Math.max(max, i - start + 1);
				}
			}
		}
		return max;
	}

}
