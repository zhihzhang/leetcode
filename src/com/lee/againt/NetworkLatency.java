package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkLatency {

	public static void main(String[] args) {
		NetworkLatency obj = new NetworkLatency();
		int[][] times = new int[][] { { 1, 2, 1 }, { 2, 1, 3 } };
		// int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
		System.out.println(obj.networkDelayTime(times, 2, 2));

	}
	// N is target
	// [[2,1,1],[2,3,1],[3,4,1]]

	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] array : times) {
			if (!graph.containsKey(array[0])) {
				graph.put(array[0], new ArrayList<int[]>());
			}
			graph.get(array[0]).add(new int[] { array[1], array[2] });
		}
		if (!graph.containsKey(K)) {
			return -1;
		}
		int[] memo = new int[N+1];
		Arrays.fill(memo, -1);
		explore(graph, K, memo, 0);
		int max = 0;
		for (int i=1;i<=N;i++) {
			int n = memo[i];
			if (n == -1) {
				return -1;
			}
			max = Math.max(max, n);
		}
		return max;
	}

	public void explore(Map<Integer, List<int[]>> graph, int from, int[] memo, int pre) {
		if (memo[from] == -1 || memo[from] > pre) {
			memo[from] = pre;
		} else if (memo[from] <= pre) {
			return;
		}		
		if (graph.get(from) == null) {
			return;
		}
		for (int[] to : graph.get(from)) {
			int curr = to[1];
			explore(graph, to[0], memo, pre + curr);
		}
	}

}
