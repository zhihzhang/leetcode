package com.lee.aafour;

import java.util.Arrays;

public class DungeonGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = new int[][]{
			{-2,-3,3},
			{-5,-10,1},
			{10,30,-5}
		};
		DungeonGame obj = new DungeonGame();
		System.out.println(obj.calculateMinimumHP(nums));

	}

	public int calculateMinimumHP(int[][] dungeon) {
		int x = dungeon.length;
		int y = dungeon[0].length;
		int[][] dp = new int[x][y];
		for (int i = 0; i < x; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[x - 1][y - 1] = 1 - dungeon[x - 1][y - 1];
		if (dp[x - 1][y - 1] < 0) {
			dp[x - 1][y - 1] = 1;
		}
		for (int i = x - 1; i >= 0; i--) {
			for (int j = y - 1; j >= 0; j--) {
				if (i == x - 1 && j == y - 1) {
					continue;
				}
				int a = Integer.MAX_VALUE;
				int b = Integer.MAX_VALUE;
				if (j < y - 1) {
					a = Math.min(dp[i][j], dp[i][j + 1] - dungeon[i][j]);
				}
				if (i < x - 1) {
					b = Math.min(dp[i][j], dp[i + 1][j] - dungeon[i][j]);
				}
				dp[i][j] = Math.min(a, b);
				if(dp[i][j]<0){
					dp[i][j]=1;
				}
			}
		}
		if(dp[0][0]<0){
			dp[0][0]=1;
		}
		return dp[0][0];
	}

}
