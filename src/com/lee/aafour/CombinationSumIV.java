package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV {

	public static void main(String[] args) {
		CombinationSumIV obj = new CombinationSumIV();
		int[] nums = new int[] { 1, 2, 3 };
		int t = obj.combinationSum4(nums, 4);
		System.out.println(t);

	}

	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int n : nums) {
				if (i - n >= 0) {
					dp[i] += dp[i - n];
				}
			}
		}
		return dp[target];
	}

	// public int combinationSum4(int[] nums, int target) {
	// Arrays.sort(nums);
	// List<Integer> list = new ArrayList<>();
	// List<List<Integer>> result = new ArrayList<>();
	// backTrace(nums, target, list, result);
	// System.out.println(result.toString());
	// return result.size();
	// }
	//
	// public void backTrace(int[] nums, int target, List<Integer> list,
	// List<List<Integer>> result){
	// if (target == 0) {
	// List<Integer> t = new ArrayList<>();
	// t.addAll(list);
	// result.add(t);
	// return;
	// }
	// if(target<0){
	// return;
	// }
	// for(int n:nums){
	// list.add(n);
	// backTrace(nums, target - n, list, result);
	// list.remove(list.size()-1);
	// }
	// }

}
