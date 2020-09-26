package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class NextPermutation {

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();
		int[] nums = new int[] { 1, 2, 3 };
		obj.nextPermutation(nums);
		obj.nextPermutation(new int[]{3,2,1});
		obj.nextPermutation(new int[]{1,1});
		obj.nextPermutation(new int[]{2,3,1});
		obj.nextPermutation(new int[]{3,1,2});
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
	// 1,2,3 → 1,3,2
	// 3,2,1 → 1,2,3
	// 1,1,5 → 1,5,1
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int last = nums[nums.length - 1];
		List<Integer> list = new ArrayList<>();
		list.add(last);
		int i = nums.length - 2;
		for (; i >= 0; i--) {
			list.add(nums[i]);
			if (nums[i] < nums[i+1]) {
				Collections.sort(list);
				int idx = list.lastIndexOf(nums[i]);
				nums[i] = list.get(idx+1);
				list.remove(idx+1);
				break;
			}
		}
		i++;
		for (int n : list) {
			nums[i++] = n;
		}
		System.out.println(Arrays.toString(nums));
	}

}
