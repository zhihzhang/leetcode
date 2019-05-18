package com.lee.again;

import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstMissingPositive(int[] nums) {
        if(nums.length==0){
            return 1;
        }
		boolean hasOne = false;
		for (int i = 0; i < nums.length; i++) {
			if (hasOne == false && nums[i] == 1) {
				hasOne = true;
			}
			if (nums[i] > nums.length) {
				nums[i] = -1;
			}
		}
		if (hasOne && nums.length == 1) {
			return 2;
		}
		
		int[] temp = new int[nums.length];
		Arrays.fill(temp, 1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				temp[nums[i]-1] = -1;
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > 0) {
				return i+1;
			}
		}
		return temp.length + 1;

	}

}
