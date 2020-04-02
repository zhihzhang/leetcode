package com.lee.againt;

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();
		int[] nums = new int[] { 2, 3, 1, 4, 1 };
		System.out.println(obj.increasingTriplet(nums));
	}

	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= first) {
				first = n;
			} else if (n <= second) {
				second = n;
			} else {
				return true;
			}
		}
		return false;
	}

}
