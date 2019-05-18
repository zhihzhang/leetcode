package com.lee.twopointers;

public class MoveZeroes283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroes(int[] nums) {
		int l = 0;
		int r = 0;

		int c = 0;
		while (l <= r) {
			if (nums[l] == 0) {
				c++;
				while (nums[r] == 0 && r < nums.length) {
					r++;
				}
			}
		}

	}

}
