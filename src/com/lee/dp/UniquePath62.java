package com.lee.dp;

public class UniquePath62 {

	public static void main(String[] args) {
		int w = uniquePaths(3, 2);
		System.out.println(w);
	}


	
	
    public static int uniquePaths(int x, int y) {
		int value[][] = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == 0 && j == 0) {
					value[0][0] = 1;
				} else if (i == 0) {
					value[0][j] = 1;
				} else if (j == 0) {
					value[i][0] = 1;
				} else {
					value[i][j] = value[i - 1][j] + value[i][j - 1];
				}
			}
		}

		return value[x - 1][y - 1];
	}

}
