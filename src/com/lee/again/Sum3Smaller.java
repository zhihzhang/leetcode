package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum3Smaller {

	public static void main(String[] args) {
		Sum3Smaller obj = new Sum3Smaller();
		System.out.println(obj.threeSumSmaller(new int[]{-2, 0,0,2,2}, 2));

	}

	// -2 0 0 2 2
	// -2 -1 -1 0 1 1 2 5
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
//		Set<String> dupSet = new HashSet<>();
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int key = target - nums[i] - nums[j];
				for (int index = j + 1; index < nums.length; index++) {
					if (nums[index] >= key) {
						break;
					}
					count++;
//					List<Integer> list = new ArrayList<>();
//					list.add(i);
//					list.add(j);
//					list.add(index);
//					Collections.sort(list);
//					dupSet.add(list.toString());
				}
			}
		}
		return count;
	}

}
