package com.lee.again;

public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates obj = new RemoveDuplicates();
		System.out.println(obj.removeDuplicates(new int[]{0,1,1,1,2,2,3,5,6}));
	}

	public int removeDuplicates(int[] nums) {
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				nums[++index] = nums[i];
			}
		}
		return index+1;
	}

}
