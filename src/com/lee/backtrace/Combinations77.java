package com.lee.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations77 {

	public static void main(String[] args) {
		combine(4,2);
	}
	
	
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
	    int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
	    backtrack(list, new ArrayList<>(), nums, 0, k);
	    return list;
    }
    
    public static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start, int total){
		if(tempList.size()==total){
			System.out.println("...temp " + tempList);
			list.add(new ArrayList<>(tempList));
		}
		if (tempList.size() >= total) {
			return;
		}
	    for(int i = start; i < nums.length; i++){
	    	if(tempList.contains(nums[i])){
	    		continue;
	    	}
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i+1, total);
	        tempList.remove(tempList.size() - 1);
	    }
	}
}
