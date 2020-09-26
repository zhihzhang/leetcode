package com.lee.againt;

public class MinimumDomino {

	public static void main(String[] args) {
		MinimumDomino obj = new MinimumDomino();
		int t = obj.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 });
		System.out.println(t);

	}

	public int minDominoRotations(int[] A, int[] B) {
		int result = -1;
		for (int i = 1; i < 7; i++) {
			int count = -1;
			int c0 = check(A, B, i);
			int c1 = check(B, A, i);
			if (c0 != -1 && c1 != -1) {
				count = Math.min(c0, c1);
			} else if (c0 != -1) {
				count = c0;
			} else if (c1 != -1) {
				count = c1;
			}
			if (count != -1 && result != -1) {
				result = Math.min(count, result);
			} else if (count != -1 && result == -1) {
				result = count;
			}
			
		}
		return result;
	}

	public int check(int[] A, int[] B, int i) {
		int count = 0;
		for (int j = 0; j < A.length; j++) {
			if (A[j] != i && B[j] != i) {
				return -1;
			} else if (A[j] == i) {
				continue;
			} else if (B[j] == i) {
				count++;
			}
		}
		return count;
	}

}
