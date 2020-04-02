package com.lee.againt;

import java.util.Arrays;

public class SpiralMatrixII {

	public static void main(String[] args) {
		SpiralMatrixII obj = new SpiralMatrixII();
		int[][] matrixs = obj.generateMatrix(4);
		System.out.println(Arrays.toString(matrixs[0]));
		System.out.println(Arrays.toString(matrixs[1]));
		System.out.println(Arrays.toString(matrixs[2]));
		System.out.println(Arrays.toString(matrixs[3]));
	}

	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		int[][] matrixs = new int[n][n];
		int l = 0, r = n - 1, t = 0, b = n - 1;
		int v = 1;
		while (l <= r && t <= b) {
			for (int i = l; i <= r; i++) {
				matrixs[t][i] = v++;
			}
			for (int i = t + 1; i <= b; i++) {
				matrixs[i][r] = v++;
			}
			for (int i = r - 1; i >= l && t != b; i--) {
				matrixs[b][i] = v++;
			}
			for (int i = b - 1; i > t && l != r; i--) {
				matrixs[i][l] = v++;
			}
			l++;
			r--;
			t++;
			b--;
		}

		return matrixs;
	}

}
