package com.lee.againt;

import java.util.Arrays;

public class MergeSortMain {

	public static void main(String[] args) {
		int[] array = new int[]{12,1,10,50,5,15,45, 67,76,88,99};
//		int[] array = new int[]{12,1,10,50};
		mergeSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}

	}

	public static void mergeSort(int[] nums, int left, int right) {
//		System.out.println(left + "..." + right);
		if (right - left <= 0) {
			return;
		}
		int mid = (right + left) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);

		
		merge(nums, left, mid, right);
	}

	public static void merge(int[] nums, int left, int mid, int right) {
		int[] t = Arrays.copyOf(nums, nums.length);
		int rl = mid + 1;
		int i = left;
		while (left <= mid && rl <= right) {
			if (nums[left] < nums[rl]) {
				t[i++] = nums[left++];
			} else {
				t[i++] = nums[rl++];
			}
		}
		while (left <= mid) {
			t[i++] = nums[left++];
		}
		while (rl <= right) {
			t[i++] = nums[rl++];
		}
//		nums = t;
		for (i = 0; i < nums.length; i++) {
			nums[i] = t[i];
		}
	}

}
