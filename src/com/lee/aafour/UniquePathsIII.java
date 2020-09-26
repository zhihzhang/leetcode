package com.lee.aafour;

public class UniquePathsIII {

	public static void main(String[] args) {
		int[][] grid = new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		UniquePathsIII obj = new UniquePathsIII();
		int x = obj.uniquePathsIII(grid);
		System.out.println(x);
	}

	int count = 0;
	int emptyCount = 0;

	public int uniquePathsIII(int[][] grid) {
		int x = -1;
		int y = -1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					x = i;
					y = j;
				} else if (grid[i][j] == 0){
					emptyCount++;
				}
			}
		}
		dfs(grid, x, y, 0);
		return count;
	}

	public void dfs(int[][] grid, int i, int j, int step) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == 2 && step == emptyCount) {
			count++;
			return;
		} else if (grid[i][j] == 0) {
			grid[i][j] = -1;
			dfs(grid, i-1, j, step+1);
			dfs(grid, i+1, j, step+1);
			dfs(grid, i, j-1, step+1);
			dfs(grid, i, j+1, step+1);
			grid[i][j] = 0;
		} else if (grid[i][j] == 1) {
			dfs(grid, i-1, j, 0);
			dfs(grid, i+1, j, 0);
			dfs(grid, i, j-1, 0);
			dfs(grid, i, j+1, 0);
		}
	}
	
//	public void dfs(int[][] grid, int i, int j, int step) {
//		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
//			return;
//		}
//		if (grid[i][j] == 2 && step == emptyCount) {
//			count++;
//			return;
//		} else if (grid[i][j] == 0) {
//			grid[i][j] = -1;
//			dfs(grid, i-1, j, step+1);
//			dfs(grid, i+1, j, step+1);
//			dfs(grid, i, j-1, step+1);
//			dfs(grid, i, j+1, step+1);
//			grid[i][j] = 0;
//		} else if (grid[i][j] == 1) {
//			dfs(grid, i-1, j, step+1);
//			dfs(grid, i+1, j, step+1);
//			dfs(grid, i, j-1, step+1);
//			dfs(grid, i, j+1, step+1);
//		}
//	}

}
