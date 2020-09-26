package com.lee.aathird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[] {};
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<>();
		int l = 0;
		int r = 0;
		while (l < nums1.length && r < nums2.length) {
			if (nums1[l] == nums2[r]) {
				if(!list.contains(nums1[l])){
					list.add(nums1[l]);
				}
				l++;
				r++;
			} else if (nums1[l] < nums2[r]) {
				l++;
			} else {
				r++;
			}
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

}
