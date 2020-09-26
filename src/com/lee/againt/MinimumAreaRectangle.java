package com.lee.againt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinimumAreaRectangle {

	public static void main(String[] args) {
		MinimumAreaRectangle obj = new  MinimumAreaRectangle();
		int[][] a = new int[][]{
//			{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}
			{1,1},{1,2},{3,1},{3,2}
		};
		System.out.println(obj.minAreaRect(a));
		
		

	}

	public int minAreaRect(int[][] points) {
		Map<Integer, List<Integer>> mapX = new TreeMap<>();
		Map<Integer, List<Integer>> mapY = new TreeMap<>();

		int min = Integer.MAX_VALUE;
		for (int[] p : points) {
			if (!mapX.containsKey(p[0])) {
				mapX.put(p[0], new ArrayList<>());
			}
			mapX.get(p[0]).add(p[1]);
			
			if (!mapY.containsKey(p[1])) {
				mapY.put(p[1], new ArrayList<>());
			}
			mapY.get(p[1]).add(p[0]);
		}

		for (int[] p1 : points) {
			for (int[] p2 : points) {
				if (p1[0] >= p2[0] || p1[1] >= p2[1]) {
					continue;
				}
				if (mapX.get(p1[0]).contains(p2[1]) && mapY.get(p1[1]).contains(p2[0])) {
					int t = (p2[0] - p1[0]) * (p2[1] - p1[1]);
					min = Math.min(t, min);
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			return 0;
		}

		return min;
	}

}
