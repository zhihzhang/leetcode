package com.lee.aafour;

import java.util.Arrays;

public class WiggleSortTwo {

	public static void main(String[] args) {
		WiggleSortTwo obj = new WiggleSortTwo();
		int[] nums = new int[]{1,5,1,1,6,4};
		obj.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	// [1, 5, 1, 1, 6, 4]
	// 1 1 1 4 5 6
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int size = nums.length;
		int[] a = new int[size];
		int l = 0;
		int r = (size + 1) / 2;
		int i = 0;
		while (r < size) {
			a[i++] = nums[l++];
			a[i++] = nums[r++];
		}
		if (i < size) {
			a[i] = nums[l];
		}
		for(int j=0;j<size;j++){
			nums[j]=a[j];
		}
	}

	public void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
