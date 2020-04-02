package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakesandLadders {

	public static void main(String[] args) {
		SnakesandLadders obj = new SnakesandLadders();
		// int[][] board = new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1,
		// -1, -1, -1, -1 },
		// { -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1,
		// -1, -1, -1 },
		// { -1, 15, -1, -1, -1, -1 } };
		// int[][] board = new int[][] { { -1, -1, -1}, { -1, 9, 8 },
		// { -1, 8, 9 } };
		int[][] board = new int[][] { 
			    { -1, -1, -1, -1, 48, 5, -1 }, 
				{ 12, 29, 13, 9, -1, 2, 32 },
				{ -1, -1, 21, 7, -1, 12, 49 }, 
				{ 42, 37, 21, 40, -1, 22, 12 }, 
				{ 42, -1, 2, -1, -1, -1, 6 },
				{ 39, -1, 35, -1, -1, 39, -1 }, 
				{ -1, 36, -1, -1, -1, -1, 5 } };

		System.out.println(obj.snakesAndLadders(board));
	}

	Map<Integer, Integer> cache = new HashMap<>();
	int min = Integer.MAX_VALUE;

	public int snakesAndLadders(int[][] board) {
		List<Integer> list = getNum(board);
		dps(list, 1, 0);
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}

	public void dps(List<Integer> list, int key, int depth) {
		if (depth >= min) {
			return;
		}
		if (key == list.size() - 1) {
			min = Math.min(min, depth);
			return;
		}
		if (key + 6 >= list.size() - 1) {
			min = Math.min(min, depth + 1);
			return;
		}
		if (cache.containsKey(key)) {
			cache.get(key);
		}

		List<Integer> next = new ArrayList<>();
		for (int k = 6; k > 0; k--) {
			int t = list.get(key + k);
			if (t == -1) {
				next.add(key + k);
				continue;
			} 
			
			while (t != -1) {
				t = list.get(t);
			}
			if (t > key + k) {
				next.add(t);
			}
		}
		Collections.sort(next, Collections.reverseOrder());

		for (int v : next) {
			dps(list, v, depth + 1);
		}

		cache.put(key, depth + 1);
	}

	public List<Integer> getNum(int[][] board) {
		List<Integer> list = new ArrayList<>();
		list.add(0);

		int row = board.length;
		int column = board[0].length;
		boolean flag = false;
		for (int i = row - 1; i > -1; i--) {
			if (flag) {
				for (int j = column - 1; j > -1; j--) {
					list.add(board[i][j]);
				}
				flag = false;
			} else {
				for (int j = 0; j < column; j++) {
					list.add(board[i][j]);
				}
				flag = true;
			}
		}
		return list;
	}

}
