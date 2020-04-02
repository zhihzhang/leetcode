package com.lee.againt;

public class LongestMountain {

	public static void main(String[] args) {
		LongestMountain obj = new LongestMountain();
//		System.out.println(obj.longestMountain(new int[] { 2,3,3,2,0,2 }));
		System.out.println(obj.longestMountain(new int[] { 875,884,239,731,723,685 }));

	}

	// 2,1,4,7,3,2,5
	// 2, 1, 4, 7
	// 1,2,3,2,1,4,5,6,7
	// 7,3,2
	// 0 2 2
	//[2,3,3,2,0,2]
	public int longestMountain(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int max = 0;
		boolean isUp = true;
		while (left < A.length) {
			if (isUp) {
				while (right + 1 < A.length && A[right] < A[right + 1]) {
					right++;
				}
				if (right == left) {
					left = right + 1;
					right = left;
				} else {
					isUp = false;
				}
			} else {
				while (right + 1 < A.length && A[right] > A[right + 1]) {
					right++;
				}
				if (A[right] >= A[right - 1]) {
					left = right + 1;
					right = left;
				} else {
					max = Math.max(max, right - left + 1);
					left = right;
				}
				isUp = true;
			}
		}
		return max;
	}

}
