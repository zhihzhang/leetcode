package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";

	}
	
	public int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(index[i], nums[i]);
		}
		int[] r = new int[list.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = list.get(i);
		}
		return r;
	}

}
