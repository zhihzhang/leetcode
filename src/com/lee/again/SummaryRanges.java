package com.lee.again;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		int l = 0;
		int r = 0;
		int n = nums.length;
		while (l < nums.length) {
			while (r + 1 < n && nums[r+1] - nums[r] == 1) {
				r++;
			}
			if (l == r) {
				list.add(nums[l] + "");
			} else {
				list.add(nums[l] + "->" + nums[r]);
			}
			l = r + 1;
			r = l;
		}
		return list;
	}

}
