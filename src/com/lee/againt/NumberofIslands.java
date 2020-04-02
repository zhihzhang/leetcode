package com.lee.againt;

public class NumberofIslands {
	boolean[][] visited;
	int count = 0;

	public void travel(char[][] grid, int i, int j, int x, int y) {
		if (i < 0 || j < 0 || i >= x && j >= y) {
			return;
		}
		visited[i][j] = true;
		travel(grid, i - 1, j, x, y);
		travel(grid, i, j - 1, x, y);
		travel(grid, i + 1, j, x, y);
		travel(grid, i, j + 1, x, y);
	}

	public int numIslands(char[][] grid) {
		int x = grid.length;
		int y = grid[0].length;
		visited = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					count++;
					travel(grid, i, j, x, y);
				}
			}
		}
		return count;
	}
}
