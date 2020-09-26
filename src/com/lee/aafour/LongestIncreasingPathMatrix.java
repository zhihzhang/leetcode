package com.lee.aafour;

public class LongestIncreasingPathMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int max = 0;

	public int longestIncreasingPath(int[][] matrix) {
		int[][] visited = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				traverse(matrix, visited, i, j, Integer.MIN_VALUE);
			}
		}

		return max;
	}

	public int traverse(int[][] matrix, int[][] visited, int i, int j, int pre) {
		if (i < 0 || j < 0 || i > matrix.length || j > matrix[0].length || pre >= matrix[i][j]) {
			return 0;
		}
		if (visited[i][j] > 0) {
			return visited[i][j];
		}
		int a = traverse(matrix, visited, i + 1, j, matrix[i][j]);
		int b = traverse(matrix, visited, i - 1, j, matrix[i][j]);
		int c = traverse(matrix, visited, i, j + 1, matrix[i][j]);
		int d = traverse(matrix, visited, i, j - 1, matrix[i][j]);
		int x = Math.max(a, b);
		int y = Math.max(c, d);
		int t = Math.max(x, y);
		visited[i][j] = t + 1;
		max = Math.max(max, t + 1);
		return t + 1;
	}

}
