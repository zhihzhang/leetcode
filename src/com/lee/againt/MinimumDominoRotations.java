package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class MinimumDominoRotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDominoRotations(int[] A, int[] B) {
		int[] aCount = new int[7];
		int[] bCount = new int[7];
		for (int i : A) {
			aCount[i]++;
		}
		for (int i : B) {
			bCount[i]++;
		}
		List<Integer> candidates = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			if (aCount[i] + bCount[i] >= A.length) {
				candidates.add(i);
			}
		}
		for (int v : candidates) {
			int i = 0;
			for (i = 0; i < A.length; i++) {
				if (A[i] != v && B[i] != v) {
					break;
				}
			}
			if (i == A.length) {
				return Math.min(A.length - aCount[v], A.length - bCount[v]);
			}
		}

		return -1;
	}

}
