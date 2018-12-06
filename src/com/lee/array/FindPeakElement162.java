package com.lee.array;

public class FindPeakElement162 {

	public static void main(String[] args) {
		FindPeakElement162 obj = new FindPeakElement162();
		System.out.println(obj.findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(obj.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
	}

	public int findPeakElement(int[] nums) {
		int preV = -1;
		int i = 0;
		for (i = 0; i < nums.length - 1; i++) {
			if (i == 0) {
				preV = nums[i];
				continue;
			}
			if (nums[i] > preV && nums[i] > nums[i + 1]) {
				return i;
			}
			preV = nums[i];
		}
		if (nums[i] > preV) {
			return i;
		}
		return 0;
	}

}
