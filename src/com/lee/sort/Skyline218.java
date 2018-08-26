package com.lee.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Skyline218 {

	public static void main(String[] args) {
		
		Skyline218 obj = new Skyline218();
		
		int[][] bs = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		System.out.println(Arrays.toString(bs));
		List<int[]> list = obj.getSkyline(bs);
		for (int[] t : list) {
			System.out.println(Arrays.toString(t));
		}

		
		int[][] bs2 = { { 1, 2, 1 }, { 1, 2, 2 }, { 1, 2, 3 } };
		System.out.println(Arrays.toString(bs2));
		List<int[]>  list2 = obj.getSkyline(bs2);
		for (int[] t : list2) {
			System.out.println(Arrays.toString(t));
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<int[]>();
		Queue<int[]> height = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
		Queue<int[]> start = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		Queue<int[]> end = new PriorityQueue<>((a, b) -> (a[1] - b[1]));

		for (int[] b : buildings) {
			start.add(b);
			end.add(b);
		}

		while (!end.isEmpty()) {
			int[] s = start.peek();
			int[] e = end.peek();
			if (s != null && s[0] < e[1]) {
				int oldHeight = 0;
				if (!height.isEmpty()) {
					oldHeight = height.peek()[2];
				}
				
				int oldStart = s[0];
				while (!start.isEmpty() && oldStart == start.peek()[0]) {
					height.add(start.poll());
				}
				
				int newHeight = height.peek()[2];
				if (oldHeight != newHeight) {
					int[] data = { s[0], height.peek()[2] };
					list.add(data);
				}
//				start.remove(s);
			} else if (s != null && s[0] == e[1]) {
				int oldHeight = 0;
				if (!height.isEmpty()) {
					oldHeight = height.peek()[2];
				}
				int oldStart = s[0];
				while (!start.isEmpty() && oldStart == start.peek()[0]) {
					height.add(start.poll());
				}
				
				int oldEnd = e[1];
				while (!end.isEmpty() && oldEnd == end.peek()[1]) {
					height.remove(end.poll());
				}

				int newHeight = height.peek()[2];
				if (oldHeight != newHeight) {
					int[] data = { oldStart, height.peek()[2] };
					list.add(data);
				}
//				start.remove(s);
//				end.remove(e);
			} else {
				int oldHeight = 0;
				if (!height.isEmpty()) {
					oldHeight = height.peek()[2];
				}
				
				int oldEnd = e[1];
				while (!end.isEmpty() && oldEnd == end.peek()[1]) {
					height.remove(end.poll());
				}
				
//				height.remove(e);
				
				int newHeight = 0;
				if (!height.isEmpty()) {
					newHeight = height.peek()[2];
				}
//				end.remove(e);
				if (oldHeight == newHeight) {
					continue;
				}

				if (height.isEmpty()) {
					int[] data = { e[1], 0 };
					list.add(data);
				} else {
					int[] data = { e[1], height.peek()[2] };
					list.add(data);
				}
			}
		}
		return list;
	}
}
