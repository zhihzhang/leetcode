package com.lee.again;

public class FlippinganImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			int[] t = A[i];
			int l = 0;
			int r = t.length - 1;
			while (l < r) {
				int v = t[l];
				t[l] = t[r];
				t[r] = v;
				l++;
				r--;
			}
		}
		for (int i = 0; i < A.length; i++) {
			int[] t = A[i];
			for (int j = 0; j < t.length; j++) {
				t[j] = (t[j] == 0 ? 1 : 0);
			}
		}
		return A;
	}

}
