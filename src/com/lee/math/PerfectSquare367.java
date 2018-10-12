package com.lee.math;

public class PerfectSquare367 {

	public static void main(String[] args) {
		PerfectSquare367 obj = new PerfectSquare367();
		int low = 1;
		int high = 500;
		long mid = (low + high) >>> 1;
		System.out.println("...mid " + mid);

	}
	
	public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
			long mid = (low + high) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
