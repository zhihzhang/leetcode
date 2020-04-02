package com.lee.againt;

public class PeakIndexinaMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	0,1,0
//	0,2,1,0
//	0,1,2,3,1

	public int peakIndexInMountainArray(int[] A) {
		int l = 0;
		int r = A.length - 1;
		int peak = 0;
		while (l < r) {
			int m = (l + r) / 2;
			if (A[m] < A[m + 1]) {
				l = m + 1;
				peak = l;
			} else {
				r = m;
			}
		}
		return peak;
	}

}
