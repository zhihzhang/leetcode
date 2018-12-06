package com.lee.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BrickWall554 {

	public static void main(String[] args) {
		BrickWall554 obj = new BrickWall554();
		// Map<Integer, Integer> map = new TreeMap<Integer, Integer>(new
		// Comparator<Integer>() {
		// public int compare(Integer obj1, Integer obj2) {
		// return (obj1 - obj2);
		// }
		// });
		//
		// map.put(1, 5);
		// map.put(2, 2);
		//
		// for (int k : map.keySet()) {
		// System.out.println(k);
		// }
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		wall.add(fill(new int[] { 1, 2, 2, 1 }));
		wall.add(fill(new int[] { 3, 1, 2 }));
		wall.add(fill(new int[] { 1, 3, 2 }));
		wall.add(fill(new int[] { 2, 4 }));
		wall.add(fill(new int[] { 3, 1, 2 }));
		wall.add(fill(new int[] { 1, 3, 1, 1 }));

		System.out.println(obj.leastBricks(wall));
	}

	public static List<Integer> fill(int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : a) {
			list.add(i);
		}
		return list;
	}

	public int leastBricks(List<List<Integer>> wall) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxKey = -1;
		int sum = 0;
		for (int v : wall.get(0)) {
			sum = sum + v;
		}

		for (List<Integer> row : wall) {
			int s = 0;
			for (int i : row) {
				s = s + i;
				if (s == sum) {
					break;
				}
				map.put(s, map.getOrDefault(s, 0) + 1);
				if (maxKey == -1) {
					maxKey = s;
				} else if (s != maxKey) {
					int sv = map.get(s);
					int m = map.get(maxKey);
					if (sv > m) {
						maxKey = s;
					}
				}
			}
		}
		if(maxKey==-1){
			return wall.size();
		}

		return wall.size() - map.get(maxKey);

	}

}
