package com.lee.again;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null || nums.length==0){
			return new int[]{};
		}
		Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < k-1; i++) {
			queue.add(nums[i]);
		}

		int[] array = new int[nums.length - k + 1];

		int l = 0;
		int r = k - 1;
		while (r < nums.length) {
			queue.add(nums[r]);
			array[l] = queue.peek();
			l++;
			r++;
			queue.remove((Object) nums[l - 1]);
		}
		return array;
	}

}
