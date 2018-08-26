package com.lee.divide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Skyline218 {

	//https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space)
	public static void main(String[] args) {
		Skyline218 obj = new Skyline218();

		Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
		queue.add(4);
		queue.add(5);
		queue.add(7);
		queue.add(8);
		
		queue.remove(7);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}

	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		for (int[] b : buildings) {
			height.add(new int[] { b[0], -b[2] });
			height.add(new int[] { b[1], b[2] });
		}
		Collections.sort(height, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
		queue.offer(0);
		int prev = 0;
		for (int[] h : height) {
			if (h[1] < 0) {
				queue.offer(-h[1]);
			} else {
				queue.remove(h[1]);
			}
			int cur = queue.peek();
			if (prev != cur) {
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}

}
