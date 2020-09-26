package com.lee.aafour;

public class ContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// [0,1,0]
	public int findMaxLength(int[] nums) {
		int[] sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i] = sum[i-1] + nums[i];
		}
		for (int l = nums.length; l >= 2; l--) {
			if (l % 2 > 0) {
				continue;
			}
			for (int i = nums.length - 1; i - l + 1 >= 0; i--) {
				int s = sum[i + 1] - sum[i - l];
				if (s * 2 == l) {
					return l;
				}
			}
		}
		return 0;
	}

}
