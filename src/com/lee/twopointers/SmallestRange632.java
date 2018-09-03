package com.lee.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestRange632 {
	
	public static List<Integer> getList(int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : a) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		SmallestRange632 obj = new SmallestRange632();
		int[] a = {4,10,15,24,26};
		int[] b = {0,9,12,20};
		int[] c = {5,18,22,30};
		
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		nums.add(getList(a));
		nums.add(getList(b));
		nums.add(getList(c));

//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//
//		List<Integer> temp = list.subList(2, 6);
//		System.out.println(temp.size());
//		System.out.println(temp.get(0));
		
		int[] r = obj.smallestRange(nums);
		System.out.println(Arrays.toString(r));

	}

	public int[] smallestRange(List<List<Integer>> nums) {
		int[] result = new int[2];

		List<Integer> temp = new ArrayList<Integer>();
		temp.add(Integer.MIN_VALUE);
		temp.add(Integer.MAX_VALUE);

		for (int i = 0; i < nums.size(); i++) {
			temp = this.getSmallestRange(temp, nums.get(i));
			if (temp == null) {
				return null;
			}
		}
		result[0] = temp.get(0);
		result[1] = temp.get(temp.size() - 1);
		return result;
	}

	public List<Integer> getSmallestRange(List<Integer> temp, List<Integer> nums) {
		int a = temp.get(0);
		int b = temp.get(temp.size() - 1);

		int start = 0;
		int end = nums.size() - 1;
		while (nums.get(start) < a && start < nums.size()) {
			start++;
		}
		while (nums.get(end) > b && end > -1) {
			end--;
		}
		if (end >= start) {
			System.out.println("...start "+ start + "   , end " + end);
			nums.add(1);
			return nums.subList(start, end + 1);
		}
		return null;

	}

}
