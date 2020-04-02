package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		int l = 0;
		int r = 0;

		while (r < nums.length) {
			if (r < nums.length-1 && nums[r + 1] - nums[r] == 1) {
				r++;
			} else {
				list.add(nums[l] + "->" + nums[r]);
				l = r + 1;
				r = l;
			}

		}
		return list;
	}

}
