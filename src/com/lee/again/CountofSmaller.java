package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountofSmaller {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(3);
		list.add(3);
		Collections.sort(list);
		System.out.println(Collections.binarySearch(list, 3));
//		queue.add(4);
//		queue.add(5);
//		queue.add(7);
		
		CountofSmaller obj = new CountofSmaller();
		obj.countSmaller(new int[]{5,2,6,1});
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums.length == 0) {
			return list;
		}
		List<Integer> queue = new ArrayList();
		queue.add(nums[nums.length - 1]);
		list.add(0);
		if (nums.length == 1) {
			return list;
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			queue.add(nums[i]);
			Collections.sort(queue);
			int k = queue.indexOf(nums[i]);
			if (k == -1) {
				k = 0;
			}
			list.add(k);
		}
		Collections.reverse(list);
		return list;
	}

}
