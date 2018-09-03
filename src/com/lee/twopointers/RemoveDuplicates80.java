package com.lee.twopointers;

public class RemoveDuplicates80 {

	public static void main(String[] args) {
		RemoveDuplicates80 obj = new RemoveDuplicates80();

		int[] nums = {1,1,1,2,2,3};
		int len = obj.removeDuplicates(nums);
		System.out.println("..len " + len);

		// any modification to nums in your function would be known by the
		// caller.
		// using the length returned by your function, it prints the first len
		// elements.
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + ",");
		}
	}

	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length < 3) {
			return nums.length;
		}
		int slow = 2;
		int sameCount = 1;
		
		if (nums[0] == nums[1]) {
			sameCount = 2;
		}
		
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				sameCount++;
				if (sameCount <= 2) {
					nums[slow++] = nums[i];
				}
			} else {
				nums[slow++] = nums[i];
				sameCount = 1;
			}
		}
		return slow;
	}

}
