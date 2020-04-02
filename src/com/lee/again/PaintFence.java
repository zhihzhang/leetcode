package com.lee.again;

public class PaintFence {

	public static void main(String[] args) {
		PaintFence obj = new PaintFence();
		System.out.println(obj.numWays(3, 2));

	}
	
    public int numWays(int n, int k) {
		int[] sameColor = new int[n];
		int[] differentColor = new int[n];
		sameColor[0] = 0;
		differentColor[0] = k;
		for (int i = 1; i < n; i++) {
			differentColor[i] = sameColor[i-1]*(k-1) + differentColor[i-1]*(k-1);
			sameColor[i] = differentColor[i-1];
		}
        return differentColor[n-1] + sameColor[n-1];
    }

}
