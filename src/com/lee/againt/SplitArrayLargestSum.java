package com.lee.againt;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		SplitArrayLargestSum obj = new SplitArrayLargestSum();
//		int[] nums = { 7, 2, 5, 10, 8 };
		int[] nums = { 2,3,1,2,4,3 };
//		int[] nums = { 2,3,1};
		int m = 5;
		int r = obj.splitArray(nums, m);
		System.out.println(r);
	}

	int[][] memo;

	public int splitArray(int[] nums, int m) {
		
		if (m == nums.length) {
			int w = Integer.MIN_VALUE;
			for (int n : nums) {
				w = Math.max(w, n);
			}
			return w;
		}
		
		int[] sum = new int[nums.length+1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i-1];
		}
		
		memo = new int[nums.length + 1][m + 1];
		memo[1][1] = nums[0];
		return split(nums, nums.length, m, sum);
	}

	public int split(int[] nums, int l, int m, int[] sum) {
		if (memo[l][m] != 0) {
			return memo[l][m];
		}
		if (m == 1) {
			memo[l][m] = sum[l];
			return sum[l];
		}
		int t = Integer.MAX_VALUE;
		for (int i = m - 1; i < l; i++) {
			int w = Math.max(split(nums, i, m-1 , sum), sum[l] - sum[i]);
			t = Math.min(w, t);
		}
		memo[l][m] = t;
		return t;
	}

}
