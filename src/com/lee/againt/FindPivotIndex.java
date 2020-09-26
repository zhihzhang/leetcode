package com.lee.againt;

public class FindPivotIndex {

	public static void main(String[] args) {
		FindPivotIndex obj = new FindPivotIndex();
		

	}
	
	public int pivotIndex(int[] nums) {
		long[] sums = new long[nums.length+1];
		sums[0] = 0;
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i+1] = sum;
		}

		for (int i = 0; i < nums.length; i++) {
			if (sums[i] == sum - nums[i] - sums[i]) {
				return i;
			}
		}
		return -1;
	}

}
