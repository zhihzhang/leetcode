package com.lee.againt;

public class BinarySearch {

	public static void main(String[] args) {
		int[] A = new int[] { 2, 3, 5, 7, 9 };
		int t = 15;
		int left = 0, right = A.length - 1;
		int mid = -10;
		while (left < right) {
			mid = (left + right) / 2;
			if (A[mid] == t) {
				break;
			}
			if (A[mid] < t) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			System.out.println(left + "  " + mid + "   " + right);
		}
		System.out.println(left + "  " + mid + "   " + right);
	}

}
