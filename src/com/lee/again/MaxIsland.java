package com.lee.again;

public class MaxIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[][] d = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int dfs(int[][] grid, int i, int j) {
		grid[i][j] = 0;
		int count = 1;
		for (int k = 0; k < d.length; k++) {
			int a = i + d[k][0];
			int b = j + d[k][1];
			if (a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && grid[a][b] == 1) {
				count = count + dfs(grid, a, b);
			}
		}
		return count;
	}

	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int t = dfs(grid, i, j);
					max = Math.max(max, t);
				}
			}
		}
		return max;
	}

}
