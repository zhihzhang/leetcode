package com.lee.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queens51 {

	public static void main(String[] args) {
		solveNQueens(4);
	}

	public static List<List<String>> solveNQueens(int n) {
		boolean[] usedX = new boolean[n];
		boolean[] usedZ = new boolean[2 * n];
		boolean[] usedR = new boolean[2 * n];
		List<List<String>> list = new ArrayList<List<String>>();
		backtrack(list, new ArrayList<Integer>(), 0, n, usedX, usedZ, usedR);
		System.out.println(list.size());
		for (List<String> y : list) {
			for (String s : y) {
				System.out.println(s);
			}
			System.out.println("---------------------");
		}

		return list;
	}

	public static void backtrack(List<List<String>> list, List<Integer> tempList, int y, int n, boolean[] usedX, boolean[] usedZ, boolean[] usedR) {
		if (y == n) {
			List<String> w = new ArrayList<String>();
			for (int i : tempList) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (j == i) {
						sb.append('Q');
					} else {
						sb.append('.');
					}
				}
				w.add(sb.toString());
			}

			list.add(w);
		} else {
			for (int x = 0; x < n; x++) {
				if (!usedX[x] && !usedZ[n + x - y] && !usedR[x + y]) {
					usedX[x] = true;
					usedZ[n + x - y] = true;
					usedR[x + y] = true;
					tempList.add(x);
					backtrack(list, tempList, y + 1, n, usedX, usedZ, usedR);
					usedX[x] = false;
					usedZ[n + x - y] = false;
					usedR[x + y] = false;
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

}
