package com.lee.again;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	public static void main(String[] args) {
		CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
//		int[][] flights = new int[][]{
//			{0,1,1},
//			{0,2,5},
//			{1,2,1},
//			{2,3,1}
//		};
//		
		
		int[][] flights = new int[][]{
			{0,1,5},
			{1,2,5},
			{0,3,2},
			{3,1,2},
			{1,4,1},
			{4,2,1}
		};
		int w = obj.findCheapestPrice(5, flights, 0, 2, 2);
		System.out.println(w);
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] f : flights) {
			if (!graph.containsKey(f[0])) {
				graph.put(f[0], new HashMap<Integer, Integer>());
			}
			graph.get(f[0]).put(f[1], f[2]);
		}

		int[] costs = new int[n];
		int[] temp = new int[n];
		Arrays.fill(costs, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		costs[src] = 0;
		temp = Arrays.copyOf(costs, n);

		int level = 0;
		int count = 1;
		int tempCount = 0;
		while (!queue.isEmpty()) {
			int key = queue.poll();
			count--;
			Map<Integer, Integer> map = graph.get(key);
			if (map != null) {
				int c = temp[key];
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					int d = entry.getKey();
					if (costs[d] == -1 || costs[d] > c + entry.getValue()) {
						costs[d] = c + entry.getValue();
					}
					queue.add(d);
					tempCount++;
				}
			}
			if (count == 0) {
				temp = Arrays.copyOf(costs, n); 
				count = tempCount;
				tempCount = 0;
                if (level == K) {
				    break;
			    }
				level++;
			}
		}

		return costs[dst];
	}
}
