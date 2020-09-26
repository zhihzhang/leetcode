package com.lee.againt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DailyTemperatures {

	public static void main(String[] args) {
		DailyTemperatures obj = new DailyTemperatures();
		int[] r = obj.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
		System.out.println(Arrays.toString(r));

	}
	
	public int[] dailyTemperatures(int[] T) {
		int[] arr = new int[T.length];
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < T.length; i++) {
			int v = T[i];
			while (!queue.isEmpty() && queue.peek()[0] < v) {
				int[] t = queue.poll();
				arr[t[1]] = i - t[1];
			}
			queue.offer(new int[] { v, i });
		}
		return arr;
	}

}
