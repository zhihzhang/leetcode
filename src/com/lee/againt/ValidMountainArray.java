package com.lee.againt;

public class ValidMountainArray {

	public static void main(String[] args) {
		ValidMountainArray obj = new ValidMountainArray();
		System.out.println(obj.validMountainArray(new int[]{3,2,1}));

	}

	public boolean validMountainArray(int[] A) {
		if (A[0] > A[1]) {
			return false;
		}
		int i = 1;
		while (i < A.length && A[i] > A[i - 1]) {
			i++;
		}
		if (i == A.length) {
			return false;
		}
		while (i < A.length && A[i] < A[i - 1]) {
			i++;
		}
		if (i < A.length) {
			return false;
		}
		return true;
	}

}
