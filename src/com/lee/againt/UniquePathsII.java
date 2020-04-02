package com.lee.againt;

public class UniquePathsII {

	public static void main(String[] args) {
		UniquePathsII obj = new UniquePathsII();

	}
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int y = obstacleGrid.length;
    	int x = obstacleGrid[0].length;
    	
		int value[][] = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(obstacleGrid[i][j]==1){
					value[i][j]=0;
					continue;
				}
				if (i == 0 && j == 0) {
					value[0][0] = 1;
				} else if (i == 0) {
					value[0][j] = value[0][j-1];
				} else if (j == 0) {
					value[i][0] = value[i-1][0];
				} else {
					value[i][j] = value[i - 1][j] + value[i][j - 1];
				}
			}
		}

		return value[x - 1][y - 1];
	}

}
