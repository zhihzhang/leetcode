package com.lee.twopointers;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets903 {

	public static void main(String[] args) {
		FruitIntoBaskets903 obj = new FruitIntoBaskets903();
		System.out.println(obj.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
	}

	public int totalFruit(int[] tree) {
		Map<Integer, Integer> map = new HashMap<>();

		int left = 0;
		int right = 0;
		int max = 0;
		int count = 0;
		while (right < tree.length) {
			map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
			if (map.size() <= 2) {
				count++;
				max = Math.max(count, max);
				right++;
			} else {
				map.remove(tree[right]);
				while (left <= right) {
					int t = map.get(tree[left]);
					count--;
					if (t == 1) {
						map.remove(tree[left]);
						left++;
						break;
					} else {
						map.put(tree[left], t - 1);
						left++;
					}
				}
			}
		}
		
		return max;
	}

}
