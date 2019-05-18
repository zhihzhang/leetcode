package com.lee.again;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		MoveZeroes obj = new MoveZeroes();
		int[] v = new int[] {1};
		obj.moveZeroes(v);
		System.out.println(Arrays.toString(v));

	}

	// Input: [0,1,0,3,12]
	// Input: [1,1,0,3,12]

	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		while (index < nums.length) {
			nums[index++] = 0;
		}
	}

	public void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
