package com.lee.binarysearch;

public class Search2DMatrixII240 {

	public static void main(String[] args) {
		Search2DMatrixII240 obj = new Search2DMatrixII240();

		int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

		System.out.println(obj.searchMatrix(matrix, 51));
		System.out.println(obj.searchMatrix(matrix, 14));
		System.out.println(obj.searchMatrix(matrix, 33));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int i = matrix.length - 1;
		int j = 0;
		int t = 0;

		while (i > -1 && i < matrix.length && j > -1 && j < matrix[0].length) {
			t = matrix[i][j];
			if (t == target) {
				return true;
			} else if (t > target) {
				i--;
			} else {
				j++;
			}

		}
		return false;
	}

}
