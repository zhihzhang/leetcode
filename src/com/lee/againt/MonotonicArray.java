package com.lee.againt;

public class MonotonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMonotonic(int[] A) {
		if (A.length < 2) {
			return true;
		}
		int t = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				if (t == 0) {
					t = 2;
				} else if (t == 1) {
					return false;
				}
			} else if (A[i] < A[i - 1]) {
				if (t == 0) {
					t = 1;
				} else if (t == 2) {
					return false;
				}
			}
		}
		return true;
	}

}
