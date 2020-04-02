package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		CountSmallerNumbersAfterSelf obj = new CountSmallerNumbersAfterSelf();
		int[] nums = new int[]{5,2,6,1};
		List<Integer> list = obj.countSmaller(nums);
		System.out.println(list.toString());

	}
	int[] count;
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		count = new int[nums.length];
		mergeSort(nums, 0, nums.length-1);
		for(int n: count){
			list.add(n);
		}
		return list;
	}
	
	public void mergeSort(int[] nums, int left, int right) {
		if (right - left <= 0) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid + 1, right);
		
		merge(nums, left, mid, right);
	}
	
	public void merge(int[] nums, int left, int mid, int right) {
		int[] t = Arrays.copyOf(nums, nums.length);
		int rl = mid + 1;
		int i = left;
		int tmpCount = 0;
		while (left <= mid && rl <= right) {
			if (nums[left] < nums[rl]) {
				t[i++] = nums[left++];
			} else {
				t[i++] = nums[rl++];
				tmpCount++;
				count[left] = tmpCount;
			}
		}
		while (left <= mid) {
			count[left] = tmpCount;
			t[i++] = nums[left++];
		}
		while (rl <= right) {
			t[i++] = nums[rl++];
		}
		for (int j = 0; j < nums.length; j++) {
			nums[j] = t[j];
		}
	}

}
