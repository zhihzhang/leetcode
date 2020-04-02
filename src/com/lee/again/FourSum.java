package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
	public static void main(String[] args) {
		FourSum obj = new FourSum();
		
		System.out.println(obj.fourSum(new int[] {0,0,0,0 }, 0).toString());
	}
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int a = nums[i];
			
			for (int j = i+1; j < nums.length - 2; j++) {
				if (j > i+1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int b = nums[j];
				
				int l = j + 1;
				int r = nums.length - 1;
				
				while (l < r) {
					int t = a + b + nums[l] + nums[r];
					if (t == target) {
						List<Integer> list = new ArrayList<>();
						list.add(a);
						list.add(b);
						list.add(nums[l]);
						list.add(nums[r]);
						if(!set.contains(list.toString())){
							result.add(list);
							set.add(list.toString());
						}
						
						l++;
						r--;
					} else if (t < target) {
						l++;
					} else {
						r--;
					}
				}
				
			}
			
		}
		
		return result;
    }

}
