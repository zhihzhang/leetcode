package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int k = Math.abs(nums[i]);
			int v = nums[k];
			if (v < 0) {
				list.add(k);
			} else {
				nums[k] = -nums[k];
			}
		}
		return list;
	}

}
