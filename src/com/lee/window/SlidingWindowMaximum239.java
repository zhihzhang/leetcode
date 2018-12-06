package com.lee.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class SlidingWindowMaximum239 {
	public static void main(String[] args) {
		SlidingWindowMaximum239 obj = new SlidingWindowMaximum239();
		System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));

		// Queue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
		// queue.add(6);
		// queue.add(6);
		// queue.add(6);
		// queue.add(3);
		// queue.add(2);
		// queue.add(1);
		// while(!queue.isEmpty()){
		// System.out.println(queue.poll());
		//
		// queue.remo
		// }

	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}

		int[] temp = new int[nums.length - k + 1];
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
		for (int i = 0; i < k; i++) {
			queue.offer(nums[i]);
		}

		int l = 0;
		int r = k;
		temp[l] = queue.peek();
		while (r < nums.length) {
			queue.remove(nums[l]);
			queue.offer(nums[r]);

			
			l++;
			temp[l] = queue.peek();
			r++;
		}

		return temp;
	}
}
