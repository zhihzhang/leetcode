package com.lee.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfArrays350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}

		}
		int[] r = new int[list.size()];
		int k = 0;
		for (int v : list) {
			r[k++] = v;
		}
		return r;
	}

}
