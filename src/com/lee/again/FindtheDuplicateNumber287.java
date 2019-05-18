package com.lee.again;

public class FindtheDuplicateNumber287 {

	public static void main(String[] args) {
		FindtheDuplicateNumber287 obj = new FindtheDuplicateNumber287();
		System.out.println(obj.findDuplicate(new int[]{1,3,4,2,2}));
	}

	public int findDuplicate(int[] nums) {
		int i = nums[0];
		while (true) {
			if (nums[i] < 0) {
				return i;
			}
			nums[i] = -nums[i];
			i = -nums[i];
		}
	}

}
