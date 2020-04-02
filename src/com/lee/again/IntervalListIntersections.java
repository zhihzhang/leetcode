package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class IntervalListIntersections {

	public static void main(String[] args) {
		IntervalListIntersections obj = new IntervalListIntersections();
		int[][] A = new int[][] { { 0, 2 }, { 5, 10 } };
		int[][] B = new int[][] { { 1, 5 }, { 8, 12 } };
		int[][] r = obj.intervalIntersection(A, B);
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		if(A==null || B==null || A.length==0 || B.length==0){
			return new int[][]{};
		}
		Queue<int[]> queue01 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int[] v : A) {
			queue01.add(v);
		}

		Queue<int[]> queue02 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int[] v : B) {
			queue02.add(v);
		}

		Queue<Queue<int[]>> queue = new PriorityQueue<Queue<int[]>>(new Comparator<Queue<int[]>>() {
			public int compare(Queue<int[]> o1, Queue<int[]> o2) {
				if (o1.peek()[1] == o2.peek()[1]) {
					return o1.peek()[0] - o2.peek()[0];
				}
				return o1.peek()[1] - o2.peek()[1];
			}
		});

		List<int[]> list = new ArrayList<>();
		
		queue.add(queue01);
		queue.add(queue02);

		while (queue.size()==2) {
			Queue<int[]> tq1 = queue.poll();
			Queue<int[]> tq2 = queue.peek();
			int[] a1 = tq1.poll();
			int[] b1 = tq2.peek();
			
			if (a1[1] >= b1[0]) {
				int s = Math.max(a1[0], b1[0]);
				list.add(new int[] { s, a1[1] });
			}

			if (!tq1.isEmpty()) {
				queue.add(tq1);
			}
		}
		

		int[][] r = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
			r[i] = list.get(i);
		}
		return r;
	}

}
