package com.lee.aathird;

public class MissingNumber {

	public static void main(String[] args) {
		MissingNumber obj = new MissingNumber();
		System.out.println(obj.missingNumber(new int[] { 2, 0 }));

	}

	// Input: [3,0,1]
	// Output: 2
	//
	// Input: [9,6,4,2,3,5,7,0,1]
	// Output: 8
	public int missingNumber(int[] nums) {
		int h = 1;
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (n < 0) {
				n = (-n) - 1;
			}
			if (n == nums.length) {
				h = -1;
			} else {
				nums[n] = -(nums[n] + 1);
			}
		}
		if (h > 0) {
			return nums.length;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				return i;
			}
		}
		return -1;
	}

}
