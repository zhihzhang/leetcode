package com.lee.aafour;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int missingNumber(int[] nums) {
		int l = nums.length;
		boolean hasZero = false;
		for (int n : nums) {
			int i = Math.abs(n);
			if (i < l) {
				nums[n] = -nums[n];
			}
			if (nums[n] == 0) {
				hasZero = true;
			}
		}
		for (int i = 0; i < l; i++) {
			if (nums[i] > 0) {
				return i;
			}
			if (nums[i] == 0 && hasZero == false) {
				return i;
			}
		}
		return l;
	}

}
