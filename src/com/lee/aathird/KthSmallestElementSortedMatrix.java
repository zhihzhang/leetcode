package com.lee.aathird;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (matrix[a[0]][a[1]] - matrix[b[0]][b[1]]));
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			queue.add(new int[]{i, 0});
		}
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			count++;
			if (count == k) {
				return matrix[a[0]][a[1]];
			}
			int x = a[0];
			int y = a[1];
			if (y < matrix[0].length - 1) {
				queue.add(new int[] { x, y + 1 });
			}
		}
		return -1;
	}

}
