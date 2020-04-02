package com.lee.again;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void wallsAndGates(int[][] rooms) {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					queue.add(new int[] { i, j });
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int i = pos[0];
			int j = pos[1];
			int v = rooms[i][j];
			if (i - 1 > 0 && rooms[i - 1][j] != -1 && rooms[i - 1][j] > v + 1) {
				rooms[i][j] = v + 1;
				queue.add(new int[] { i - 1, j });
			}
			if (i + 1 < rooms.length && rooms[i + 1][j] != -1 && rooms[i + 1][j] > v + 1) {
				rooms[i][j] = v + 1;
				queue.add(new int[] { i + 1, j });
			}
			if (j - 1 > 0 && rooms[i][j - 1] != -1 && rooms[i][j - 1] > v + 1) {
				rooms[i][j] = v + 1;
				queue.add(new int[] { i, j - 1 });
			}
			if (j + 1 > rooms[0].length && rooms[i][j + 1] != -1 && rooms[i][j + 1] > v + 1) {
				rooms[i][j] = v + 1;
				queue.add(new int[] { i, j + 1 });
			}
		}
	}

}
