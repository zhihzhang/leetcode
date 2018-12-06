package com.lee.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle120 {

	public static void main(String[] args) {
		Triangle120 obj = new Triangle120();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		add(new int[] { 2 }, triangle);
		add(new int[] { 3, 4 }, triangle);
		add(new int[] { 6, 5, 7 }, triangle);
		add(new int[] { 4, 1, 8, 3 }, triangle);
		int r = obj.minimumTotal(triangle);
		System.out.println(r);
	}

	public static void add(int[] a, List<List<Integer>> triangle) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : a) {
			list.add(i);
		}
		triangle.add(list);
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		List<Integer> preCost = null;
		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> list = triangle.get(i);
			List<Integer> c = new ArrayList<Integer>();
			if (i == 0) {
				c.add(list.get(0));
				preCost = c;
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				if (j == 0) {
					c.add(preCost.get(0) + list.get(0));
				} else if (j == list.size() - 1) {
					System.out.println("   j "+ j + "  i " + i + "  " + list.size());
					c.add(preCost.get(j-1) + list.get(j));
				} else {
					int t = Math.min(preCost.get(j - 1), preCost.get(j)) + list.get(j);
					c.add(t);
				}
			}
			preCost = c;
		}
		int m = Integer.MAX_VALUE;
		for (int v : preCost) {
			m = Math.min(v, m);
		}
		return m;
	}

}
