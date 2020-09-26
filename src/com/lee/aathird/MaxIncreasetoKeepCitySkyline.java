package com.lee.aathird;

public class MaxIncreasetoKeepCitySkyline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[] a = new int[x];
        int[] b = new int[y];
        for(int i=0;i<x;i++){
        	for(int j=0;j<y;j++){
        		a[i] = Math.max(a[i], grid[i][j]);
        		b[j] = Math.max(b[j], grid[i][j]);
        	}
        }
        int sum = 0;
        for(int i=0;i<x;i++){
        	for(int j=0;j<y;j++){
        		int t = Math.min(a[i], b[j]);
        		int w = Math.max(0, t - grid[i][j]);
        		sum += w;
        	}
        }
        return sum;
    }

}
