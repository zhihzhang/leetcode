package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	// use multiple solutions to solve this problem
	// https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's

	public static void main(String[] args) {
		CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
		// int[][] flights = new int[][] {
		// {0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
		int[][] flights = new int[][] { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };
		int r = obj.findCheapestPrice(5, flights, 0, 2, 2);
		System.out.println(r);
	}

	// [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
	// 3
	// [[0,1,100],[1,2,100],[0,2,500]]
	// 0
	// 2
	// 1

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < flights.length; i++) {
			if (!map.containsKey(flights[i][0])) {
				map.put(flights[i][0], new ArrayList<int[]>());
			}
			map.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
		}

		Queue<Integer> queue = new LinkedList<>();
		int stop = 0;
		queue.offer(src);
		while (!queue.isEmpty() && stop <= K) {
			int[] t = Arrays.copyOf(cost, cost.length);
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				int source = queue.poll();
				int c = cost[source];
				if (!map.containsKey(source)) {
					continue;
				}
				for (int[] array : map.get(source)) {
					if (t[array[0]] <= c + array[1]) {
						continue;
					}
					t[array[0]] = c + array[1];
					if (array[0] != dst && array[0] != src && t[array[0]] < cost[dst]) {
						queue.add(array[0]);
					}
				}
			}
			stop++;
			cost = t;
		}
		if (cost[dst] == Integer.MAX_VALUE) {
			return -1;
		}
		return cost[dst];
	}

}
