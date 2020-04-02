package com.lee.againt;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	
//	1, 4, 6
//	3, 8, 10, 11

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		return 0;
	}
	
	public double getArrayMedian(int[] nums){
		int y = nums.length;
		if (y % 2 == 0) {
			int t = y / 2;
			return ((double) nums[t - 1] + (double) nums[t]) / 2d;
		} else {
			return nums[y / 2];
		}
	}

}
