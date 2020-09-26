package com.lee.againt;

public class IncreasingTripletSubsequence01 {

	public static void main(String[] args) {
		IncreasingTripletSubsequence01 obj = new IncreasingTripletSubsequence01();
		System.out.println(obj.increasingTriplet(new int[]{5, 7, 1, 3, 2}));
	}

	// 1 2 3 4 5
	// 5 7 1 3 4 
	// 5 4 3 2 1
	public boolean increasingTriplet(int[] nums) {
		if(nums==null || nums.length<3){
			return false;
		}
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n < first) {
				first = n;
			} else if (n < second && n > first) {
				second = n;
			} else if (n > second) {
				return true;
			}
		}
		return false;
	}

}
