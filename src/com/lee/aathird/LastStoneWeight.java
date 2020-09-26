package com.lee.aathird;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lastStoneWeight(int[] stones) {
		Queue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
		for (int n : stones) {
			queue.add(n);
		}
		while (!queue.isEmpty()) {
			int n = queue.poll();
			if (queue.isEmpty()) {
				return n;
			} else {
				int m = queue.poll();
				queue.add(n - m);
			}
		}
		return 0;
	}

}
