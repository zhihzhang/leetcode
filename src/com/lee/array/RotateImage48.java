package com.lee.array;

import java.util.Arrays;

public class RotateImage48 {

	public static void main(String[] args) {
		RotateImage48 obj = new RotateImage48();
		{
			int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			obj.rotate(matrix);
			for (int i = 0; i < matrix.length; i++) {
				System.out.println(Arrays.toString(matrix[i]));
			}
		}
		{
			int[][] matrix = new int[][] { { 5, 1, 9,11 }, { 2, 4, 8,10 }, { 13, 3, 6, 7 },{15,14,12,16} };
			obj.rotate(matrix);
			for (int i = 0; i < matrix.length; i++) {
				System.out.println(Arrays.toString(matrix[i]));
			}
		}

	}

	public void rotate(int[][] matrix) {
		int s = 0;
		int e = matrix.length;
		if (e - s < 2) {
			return;
		}
		while (e - s > 1) {
			rotate(matrix, s, e-1);
			s++;
			e--;
		}
		
	}

	public void rotate(int[][] matrix, int s, int e) {
		System.out.println("rotate..." + s + ":" + e);
		for (int i = s; i < e; i++) {
			swap(matrix, s, i, i, e);
			swap(matrix, s, i, e, e - (i-s));
			swap(matrix, s, i, e - (i-s), s);
		}
	}

	public void swap(int[][] matrix, int ay, int ax, int by, int bx) {
        System.out.println(ay + ":" + ax + "    " + by + ":" + bx);
		int t = matrix[ay][ax];
		matrix[ay][ax] = matrix[by][bx];
		matrix[by][bx] = t;
	}

}
