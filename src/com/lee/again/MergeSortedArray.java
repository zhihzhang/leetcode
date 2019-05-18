package com.lee.again;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input:
	// nums1 = [1,2,3,0,0,0], m = 3
	// nums2 = [2,5,6], n = 3
	//
	// Output: [1,2,2,3,5,6]

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}
		while (i >= 0) {
			nums1[index--] = nums1[i--];
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}

}
