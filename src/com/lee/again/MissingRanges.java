package com.lee.again;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		MissingRanges obj = new MissingRanges();
		List<String> list = obj.findMissingRanges(new int[] {}, 1, 1);
		System.out.println(list.toString());
	}

	// Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
	// Output: ["2", "4->49", "51->74", "76->99"]
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<>();
		if(nums.length==0){
			if(lower==upper){
				list.add(lower + "");
			}else{
				list.add(lower + "->" + upper);
			}
			return list;
		}
		
		List<Long> numList = new ArrayList<>();
		for (long v : nums) {
			if (v >= lower && v <= upper) {
				numList.add(v);
			}
		}
		if (numList.size() == 0) {
			return list;
		}
		numList.add((long)upper + 1);

		long low = lower;
		for (long v : numList) {
			if (low < v) {
				if (low < v - 1) {
					list.add(low + "->" + (v - 1));
				} else {
					list.add(low + "");
				}
			}
			low = v + 1;
		}
		return list;
	}

}
