package com.lee.again;

public class RangeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[][] matrix;

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				sum = sum + matrix[i][j];
			}
		}
		return sum;
	}

}
