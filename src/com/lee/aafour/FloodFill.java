package com.lee.aafour;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int v = image[sr][sc];
		traverse(image, sr, sc, newColor, v);
		return image;
	}

	public void traverse(int[][] image, int i, int j, int newColor, int v) {
		if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != v) {
			return;
		}
		image[i][j] = newColor;
		traverse(image, i + 1, j, newColor, v);
		traverse(image, i - 1, j, newColor, v);
		traverse(image, i, j + 1, newColor, v);
		traverse(image, i, j - 1, newColor, v);
	}

}
