package com.lee.dp;

public class SwimRisingWater778 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		int[][] a = { { 0, 2 }, { 1, 3 } };
//		System.out.println(swimInWater(a));
//		 int[][] b = { { 0, 1, 2, 3, 4 },
//				 	{ 24, 23, 22, 21, 5 },
//				 	{ 12, 13, 14, 15, 16 },
//				 	{ 11, 17, 18, 19, 20 },
//				 	{ 10, 9, 8, 7, 6 } };
//		 System.out.println(swimInWater(b));
		 
		 int[][] c = { { 7,34,16,12,15,0},
				 		{10,26,4,30,1,20},
				 		{28,27,33,35,3,8},
				 		{29,9,13,14,11,32},
				 		{31,21,23,24,19,18},
				 		{22,6,17,5,2,25}};
				 System.out.println(swimInWater(c));
	}

//	public static int swimInWater(int[][] grid) throws InterruptedException {
//		int[][] cost = new int[grid.length][grid[0].length];
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				cost[i][j] = -1;
//			}
//		}
//		int d = getCost(grid, cost, grid.length - 1, grid[0].length - 1);
//		return d;
//	}
//
//	public static int getCost(int[][] grid, int[][] cost, int i, int j) throws InterruptedException {
//
//		// Thread.sleep(100l);
//		System.out.println("..i:" + i + "..j:" + j + "..cost:" + cost[i][j]);
//		if (cost[i][j] > -1) {
//			System.out.println("....return  " + cost[i][j]);
//			return cost[i][j];
//		}
//		if (i == 0 && j == 0) {
//			cost[0][0] = grid[0][0];
//		} else if (i == 0) {
//			cost[i][j] = Math.max(grid[0][j], getCost(grid, cost, 0, j - 1));
//		} else if (j == 0) {
//			int c = Math.min(getCost(grid, cost, i - 1, j), getCost(grid, cost, i, j + 1));
//			cost[i][j] = Math.max(grid[i][j], c);
//		} else if (j == grid[0].length - 1 && i != grid.length - 1) {
//			int c = Math.min(getCost(grid, cost, i - 1, j), getCost(grid, cost, i, j - 1));
//			cost[i][j] = Math.max(grid[i][j], c);
//		} else {
//			int c1 = Math.min(getCost(grid, cost, i - 1, j), getCost(grid, cost, i, j - 1));
//			int c2 = Math.min(c1, getCost(grid, cost, i, j + 1));
//			cost[i][j] = Math.max(grid[i][j], c2);
//		}
//		return cost[i][j];
//	}

	public static int swimInWater(int[][] grid) {
		int[][] cost = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					cost[0][0] = grid[0][0];
				} else if (i == 0) {
					cost[0][j] = Math.max(grid[0][j], cost[0][j - 1]);
				} else if (j == 0) {
					cost[i][0] = Math.max(grid[i][0], cost[i - 1][0]);
				} else {
					int minCost = Math.min(cost[i - 1][j], cost[i][j - 1]);
					cost[i][j] = Math.max(grid[i][j], minCost);
				}
//				System.out.println("...i:" + i + " ,j:" + j + " ,cost:" + cost[i][j]);
			}
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i > 0 && j == grid[0].length - 1) {
					 int c = Math.min(cost[i][j], cost[i - 1][j]);
					 cost[i][j] = Math.max(c, grid[i][j]);
				} else if (i > 0 && j < grid[0].length - 1) {
				     int c = Math.min(cost[i][j + 1], cost[i][j]);
				     cost[i][j] = Math.max(c, grid[i][j]);
				}
				// System.out.println("...i:" + i + " ,j:" + j + " ,cost:" +
				// cost[i][j]);
			}
		}
//		for (int i = 0; i < grid.length; i++) {
//			System.out.print("{");
//			for (int j = 0; j < grid[0].length; j++) {
//				System.out.print(cost[i][j] + " ");
//			}
//			System.out.println("}");
//		}
		return cost[grid.length - 1][grid[0].length - 1];
	}

}
