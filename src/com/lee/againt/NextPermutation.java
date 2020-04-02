package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(7);
		int k = Collections.binarySearch(list, 5);
		System.out.println(k);
	}

	// 1 2 4 3
	// 1 2 3 4
	// 4 3 2 1
	// 4 1 3 2

	// 2 3 1
	// 1 1 5
	// 1 5 1
	// 5 1 1

	// same value
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		List<Integer> list = new ArrayList<>();
		list.add(nums[nums.length - 1]);
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				list.add(nums[i]);

				Collections.sort(list);
				int index = Collections.binarySearch(list, nums[i]);
				while (list.get(index) == list.get(index+1)) {
					index++;
				}
				nums[i] = list.get(index + 1);
				list.remove(index + 1);

				int k = i + 1;
				for (int j = 0; j < list.size(); j++) {
					nums[k++] = list.get(j);
				}
				return;
			}
			list.add(nums[i]);
		}
		Arrays.sort(nums);
	}

}
