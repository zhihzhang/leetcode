package com.lee.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
public class Subsets78 {

	public static void main(String[] args) {
		int[] nums = {1,2,2,4};
		subsets(nums);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    list.add(new ArrayList<>());
	    System.out.println(list.size());
	    return list;
	}

	public static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		
	    System.out.println("...temp " + tempList);
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        list.add(new ArrayList<>(tempList));
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}

}
