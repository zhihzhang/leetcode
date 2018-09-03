package com.lee.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxPoints149 {

	public static void main(String[] args) {
		MaxPoints149 obj = new MaxPoints149();

	}
	
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				;
			}
		}
		Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> (b - a));
		return queue.poll();
	}

//	public int maxPoints(Point[] points) {
//		if (points == null || points.length == 0) {
//			return 0;
//		}
//		Map<Integer, Integer> mapX = new HashMap<Integer, Integer>();
//		Map<Integer, Integer> mapY = new HashMap<Integer, Integer>();
//		Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
//		Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
//		
//		for (Point p : points) {
//			mapX.put(p.x, mapX.getOrDefault(p.x, 0) + 1);
//			mapY.put(p.y, mapY.getOrDefault(p.y, 0) + 1);
//			mapA.put(p.x - p.y, mapA.getOrDefault(p.x - p.y, 0) + 1);
//			mapB.put(p.y + p.x, mapB.getOrDefault(p.y + p.x, 0) + 1);
//		}
//		Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> (b - a));
//		queue.addAll(mapX.values());
//		queue.addAll(mapY.values());
//		queue.addAll(mapA.values());
//		queue.addAll(mapB.values());
//
//		return queue.poll();
//	}

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

}
