package com.lee.dp;

public class MinPath64 {

	public static void main(String[] args) {
		int[ ] [ ] grid={{1,3,1},{1,5,1},{4,2,1}};  
		int w = getShort(grid);
		System.out.println(w);
	}
	
	public static int getShortPath(int[][] grid, int x, int y){
		int m = grid.length;
		int n = grid[0].length;
		int value = grid[x][y];
		
		if(x==m-1){
			if(y==n-1){
				return value;
			}
			return value + getShortPath(grid, x, y+1);
		}
		if(y==n-1){
			return value + getShortPath(grid, x+1, y); 
		}
		
		int r = Math.min(getShortPath(grid, x+1, y), getShortPath(grid, x, y+1));
		
		return value + r;
	}
	
	
	public static int getShort(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int value[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					value[0][0] = grid[0][0];
				} else if (i == 0) {
					value[0][j] = grid[0][j] + value[0][j - 1];
				} else if (j == 0) {
					value[i][0] = grid[i][0] + value[i - 1][0];
				} else {
					value[i][j] = Math.min(value[i - 1][j], value[i][j - 1]) + grid[i][j];
				}
			}
		}

		return value[m - 1][n - 1];
	}

}
