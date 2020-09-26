package com.lee.aafour;

import java.util.List;
import java.util.TreeMap;

public class SwimRisingWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 0,2
	// 1,3
	//
	// 0 1 2 3 4
	// 24 23 22 21 5
	// 12 13 14 15 16
	// 11 17 18 19 20
	// 10 9 8 7 6

	int max = Integer.MAX_VALUE;

	public int swimInWater(int[][] grid) {
		int[][] visited = new int[grid.length][grid[0].length];
		dfs(grid, visited, 0, 0, 0);
		return max;
	}

	public void dfs(int[][] grid, int[][] visited, int x, int y, int current) {
		if (x == grid.length-1 && y == grid[0].length-1) {
			current = Math.max(current, grid[x][y]);
			max = Math.min(current, max);
			return;
		}
		current = Math.max(current, grid[x][y]);
		if (current > max) {
			return;
		}
		visited[x][y]=1;
		TreeMap<Integer, int[]> map = new TreeMap<>();
		if (x - 1 >= 0 && visited[x-1][y]==0) {
			map.put(grid[x - 1][y], new int[] { x - 1, y });
		}
		if (y - 1 >= 0 && visited[x][y-1]==0) {
			map.put(grid[x][y - 1], new int[] { x, y - 1 });
		}
		if (x + 1 < grid.length && visited[x+1][y]==0) {
			map.put(grid[x + 1][y], new int[] { x + 1, y });
		}
		if (y + 1 < grid[0].length && visited[x][y+1]==0) {
			map.put(grid[x][y + 1], new int[] { x, y + 1 });
		}
		for(int[] v: map.values()){
			dfs(grid, visited, v[0], v[1], current);
		}
		visited[x][y]=0;
	}

}
