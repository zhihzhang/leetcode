package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int n : nums) {
			int i = Math.abs(n);
			if (nums[i - 1] > 0) {
				nums[i - 1] = -nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}
		return list;
	}

}
