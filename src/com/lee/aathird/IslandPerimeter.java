package com.lee.aathird;

public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer.bitCount(1^2);
	}

	public int islandPerimeter(int[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					sum += traverse(grid, i+1, j);
					sum += traverse(grid, i-1, j);
					sum += traverse(grid, i, j+1);
					sum += traverse(grid, i, j-1);
				}
			}
		}
		return sum;
	}

	public int traverse(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
			return 1;
		}
		return 0;
	}

}
