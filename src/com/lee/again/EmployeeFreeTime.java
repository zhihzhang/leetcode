package com.lee.again;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] employeeFreeTime(int[][][] schedule) {
		List<int[]> r = new ArrayList<>();
		Queue<Queue<int[]>> queue = new PriorityQueue<>(new Comparator<Queue<int[]>>() {
			@Override
			public int compare(Queue<int[]> o1, Queue<int[]> o2) {
				if(o1.peek()[0]==o2.peek()[0]){
					return o1.peek()[1] - o2.peek()[1];
				}
				return o1.peek()[0] - o2.peek()[0];
			}
		});
		for (int[][] t : schedule) {
			Queue<int[]> q = new LinkedList<int[]>();
			for (int[] a : t) {
				q.add(a);
			}
			if (!q.isEmpty()) {
				queue.add(q);
			}
		}
		int start = Integer.MIN_VALUE;
		// int end = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Queue<int[]> q = queue.poll();
			int[] t = q.poll();
			if (start < t[0]) {
				r.add(new int[] { start, t[0]});
				start = t[1];
			} else {
				start = Math.max(start, t[1]);
			}

			if (!q.isEmpty()) {
				queue.add(q);
			}
		}

		r.remove(0);
		int[][] result = new int[r.size()][2];
		for (int i = 0; i < r.size(); i++) {
			result[i] = r.get(i);
		}

		return result;
	}

}
