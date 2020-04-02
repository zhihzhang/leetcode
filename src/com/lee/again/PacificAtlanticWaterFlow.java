package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		int[][] a = new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		obj.pacificAtlantic(a);
	}

	// Pacific ~ ~ ~ ~ ~
	// ~ 1 2 2 3 (5) *
	// ~ 3 2 3 (4) (4) *
	// ~ 2 4 (5) 3 1 *
	// ~ (6) (7) 1 4 5 *
	// ~ (5) 1 1 2 4 *
	// * * * * * Atlantic
	public List<int[]> pacificAtlantic(int[][] matrix) {
		int[][] pa = new int[matrix.length][matrix[0].length];
		int[][] at = new int[matrix.length][matrix[0].length];
		bfs(matrix, pa, true);
		bfs(matrix, at, false);
		List<int[]> result = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (pa[i][j] == 1 && at[i][j] == 1) {
					result.add(new int[] { i, j });
				}
			}
		}
		return result;
	}

	public void bfs(int[][] matrix, int[][] d, boolean isPa) {
		int[][] visited = new int[matrix.length][matrix[0].length];
		Queue<int[]> queue = new LinkedList<>();
		if (isPa) {
			for (int i = 0; i < matrix[0].length; i++) {
				d[0][i] = 1;
				visited[0][i] = 1;
				queue.offer(new int[] { 0, i });
			}
			for (int i = 0; i < matrix.length; i++) {
				d[i][0] = 1;
				visited[i][0] = 1;
				queue.offer(new int[] { i, 0 });
			}
		} else {
			int m = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++) {
				d[i][m] = 1;
				visited[i][m] = 1;
				queue.offer(new int[] { i, m });
			}
			int n = matrix.length;
			for (int i = 0; i < matrix[0].length; i++) {
				d[n][i] = 1;
				visited[n][i] = 1;
				queue.offer(new int[] { n, i });
			}
		}
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int i = p[0];
			int j = p[1];
			if (i - 1 >= 0 && d[i - 1][j] == 0 && matrix[i - 1][j] >= matrix[i][j]) {
				d[i - 1][j] = 1;
				queue.offer(new int[] { i - 1, j });
			}
			if (i + 1 < matrix.length && d[i + 1][j] == 0 && matrix[i + 1][j] >= matrix[i][j]) {
				d[i + 1][j] = 1;
				queue.offer(new int[] { i + 1, j });
			}
			if (j - 1 >= 0 && d[i][j - 1] == 0 && matrix[i][j - 1] >= matrix[i][j]) {
				d[i][j - 1] = 1;
				queue.offer(new int[] { i, j - 1 });
			}
			if (j + 1 < matrix[0].length && d[i][j + 1] == 0 && matrix[i][j + 1] >= matrix[i][j]) {
				d[i][j + 1] = 1;
				queue.offer(new int[] { i, j + 1 });
			}
		}
	}

}
