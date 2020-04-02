package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallNumber {

	public static void main(String[] args) {
		CountSmallNumber obj = new CountSmallNumber();
		int[] nums = new int[]{-1,-1};
		List<Integer> list = obj.countSmaller(nums);
		System.out.println(list.toString());
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		int[] counts = new int[nums.length];
		int[] indexes = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexes[i] = i;
		}
		sortMerge(nums, indexes, 0, nums.length-1, counts);
		for (int n : counts) {
			list.add(n);
		}
		return list;
	}

	public void sortMerge(int[] nums, int[] indexes, int left, int right, int[] counts) {
		if (right - left < 1) {
			return;
		}
		int mid = (left+right)/2;
		sortMerge(nums, indexes, left, mid, counts);
		sortMerge(nums, indexes, mid+1, right, counts);
		
		merge(nums, indexes, left, right, mid, counts);
	}

	public void merge(int[] nums, int[] indexes, int left, int right, int mid, int[] counts) {
		int rl = mid + 1;
		int[] t = Arrays.copyOf(indexes, indexes.length);
		int i = left;
		while (left <= mid && rl <= right) {
			if (nums[indexes[left]] <= nums[indexes[rl]]) {
				t[i++] = indexes[left++];
			} else {
				for(int j=left;j<=mid;j++){
					counts[indexes[j]]++;
				}
				t[i++] = indexes[rl++];
			}
		}
		while (left <= mid) {
			t[i++] = indexes[left++];
		}
		while (rl <= right) {
			t[i++] = indexes[rl++];
		}
		for (int j = 0; j < indexes.length; j++) {
			indexes[j] = t[j];
		}
	}

}
