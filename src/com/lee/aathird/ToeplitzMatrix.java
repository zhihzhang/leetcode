package com.lee.aathird;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	  [1,2,3,4],
//	  [5,1,2,3],
//	  [9,5,1,2]
	public boolean isToeplitzMatrix(int[][] matrix) {
		int x = matrix.length;
		int y = matrix[0].length;
		for (int j = 0; j < y; j++) {
			int a = 0;
			int b = j;
			int v = matrix[a][b];
			while (a < x && b < y) {
				if (matrix[a++][b++] != v) {
					return false;
				}
			}
		}
		for (int i = x-1; i>=1; i--) {
			int a = i;
			int b = 0;
			int v = matrix[a][b];
			while (a < x && b < y) {
				if (matrix[a++][b++] != v) {
					return false;
				}
			}
		}
		return true;
	}

}
