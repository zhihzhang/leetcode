package com.lee.dp;

import java.util.Arrays;

public class MaxRectangle85 {

	public static void main(String[] args) {
		MaxRectangle85 obj = new MaxRectangle85();
		char[][] c = new char[][] { { '1', '0', '0', '0', '0', '0', '0' }, { '0', '1', '0', '1', '1', '1', '1' },
				{ '0', '1', '0', '0', '1', '1', '1' }, { '0', '1', '0', '1', '0', '0', '1' },
				{ '0', '1', '0', '1', '1', '1', '1' } };
		System.out.println(obj.maximalRectangle(c));

	}

	public int maximalRectangle(char[][] grid) {
		if(grid==null || grid.length==0){
			return 0;
		}

		int max = 0;
		int[] height = new int[grid[0].length];
		Arrays.fill(height, 0);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					height[j] += 1;
				} else {
					height[j] = 0;
				}
			}

			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					int maxG = height[j];
					int minH = maxG;

					for (int k = j + 1; k < grid[0].length; k++) {
						if (grid[i][k] == 0) {
							break;
						}
						minH = Math.min(minH, height[k]);
						maxG = Math.max(minH * (k - j + 1), maxG);
					}
					max = Math.max(max, maxG);
				}
			}

		}

		return max;
	}

}
