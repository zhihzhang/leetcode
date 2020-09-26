package com.lee.aafour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheSkylineProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] bs = new int[][]{
			{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
		};
		TheSkylineProblem obj = new TheSkylineProblem();
		obj.getSkyline(bs);

	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<>();
		Queue<Integer> height = new PriorityQueue<>((a, b) -> (b - a));
		Queue<int[]> start = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0])); // decreasing
		Queue<int[]> end = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0])); // increasing
		for (int[] b : buildings) {
			start.offer(new int[] { b[0], b[2] });
			end.offer(new int[] { b[1], b[2] });
//			height.offer(b[2]);
		}
		height.offer(0);
		list.add(new int[] { 0, 0 });
		while (!start.isEmpty() && !end.isEmpty()) {
			if (start.peek()[0] <= end.peek()[0]) {
				int[] a = start.poll();
				height.offer(a[1]);
				int[] last = list.get(list.size() - 1);
				if (height.peek() > last[1]) {
					list.add(new int[] { a[0], height.peek() });
				}
			} else if (start.peek()[0] > end.peek()[0]) {
				int[] b = end.poll();
				height.remove((Object) b[1]);
				int[] last = list.get(list.size() - 1);
				if (height.peek() < last[1]) {
					list.add(new int[] { b[0], height.peek() });
				}
			}
		}
		while (!end.isEmpty()) {
			int[] a = end.poll();
			height.remove((Object) a[1]);
			int[] last = list.get(list.size() - 1);
			if (height.peek() < last[1]) {
				list.add(new int[] { a[0], height.peek() });
			}
		}
		list.remove(0);
		List<List<Integer>> r = new ArrayList<>();
		for(int[] arr:list){
			System.out.println(Arrays.toString(arr));
			List<Integer> t = new ArrayList<>();
			for(int x:arr){
				t.add(x);
			}
			r.add(t);
		}
		return r;
	}

}
