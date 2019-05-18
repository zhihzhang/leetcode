package com.lee.again;

import java.util.Arrays;

public class SumClosest {

	public static void main(String[] args) {
		SumClosest obj = new SumClosest();
		System.out.println(obj.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));

	}

	// -1, 2, 1, -4
	// -4 -1 1 2
	// 1
	public int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		int num = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				for (int k = i + 1; k < j; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (Math.abs(target - sum) < diff) {
						diff = Math.abs(target - sum);
						num = sum;
					}
				}
			}
		}
		return num;
	}

}
