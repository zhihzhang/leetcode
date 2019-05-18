package com.lee.bfs;

import java.util.Arrays;

public class Matrix542 {

	public static void main(String[] args) {
		Matrix542 obj = new Matrix542();
		int[][] d = new int[][] { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
		obj.updateMatrix(d);
		System.out.println(Arrays.toString(d[0]));
		System.out.println(Arrays.toString(d[1]));
		System.out.println(Arrays.toString(d[2]));
		System.out.println(Arrays.toString(d[3]));
		System.out.println(Arrays.toString(d[4]));
		System.out.println(Arrays.toString(d[5]));
		System.out.println(Arrays.toString(d[6]));
		System.out.println(Arrays.toString(d[7]));
		System.out.println(Arrays.toString(d[8]));
		System.out.println(Arrays.toString(d[9]));

	}

	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return matrix;
		}
		int[][] data = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					data[i][j] = matrix[i][j];
				}
				if (matrix[i][j] == 1) {
					int a = 2000;
					if (i > 0) {
						a = data[i - 1][j];
					}
					if (j > 0) {
						a = Math.min(data[i][j - 1], a);
					}
					data[i][j] = a + 1;
				} else {
					data[i][j] = 0;
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (i == matrix.length - 1 && j == matrix[0].length - 1) {
					continue;
				}
				if (matrix[i][j] > 0) {
					int a = 2000;
					if (i < matrix.length - 1) {
						a = data[i + 1][j];
					}
					if (j < matrix[0].length - 1) {
						a = Math.min(data[i][j + 1], a);
					}
					data[i][j] = Math.min(a + 1, data[i][j]);
				} else {
					data[i][j] = 0;
				}
			}
		}
		return data;
	}

	int[][] seen;

	public int[][] updateMatrix123(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return matrix;
		}
		seen = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(matrix, i, j);
			}
		}
		return matrix;
	}

	public int dfs(int[][] matrix, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return 5000;
		}
		if (seen[i][j] == 1 || matrix[i][j] == 0) {
			seen[i][j] = 1;
			return matrix[i][j];
		}
		seen[i][j] = 2;

		int a = 5000;
		if (i > 0) {
			if (seen[i - 1][j] == 1 || matrix[i - 1][j] == 0) {
				a = matrix[i - 1][j];
			}
		}

		int c = 5000;
		if (j > 0) {
			if (seen[i][j - 1] == 1 || matrix[i][j - 1] == 0) {
				c = matrix[i][j - 1];
			}
		}

		if (a == 0 || c == 0) {
			matrix[i][j] = 1;
			seen[i][j] = 1;
			return 1;
		}

		int b = dfs(matrix, i + 1, j);
		int d = dfs(matrix, i, j + 1);

		int t = 5000;
		t = Math.min(t, a);
		t = Math.min(t, b);
		t = Math.min(t, c);
		t = Math.min(t, d);

		matrix[i][j] = t + 1;
		seen[i][j] = 1;

		return t + 1;
	}

}
