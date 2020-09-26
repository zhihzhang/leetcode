package com.lee.againt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] t : times) {
			if(!map.containsKey(t[0])){
				map.put(t[0], new ArrayList<int[]>());
			}
			map.get(t[0]).add(new int[]{t[1],t[2]});
		}
		int[] cost = new int[N];
		Arrays.fill(cost, -1);
		traverse(map, cost, K, 0);
		int max = -1;
		for (int n : cost) {
			if (n == -1) {
				return -1;
			}
			max = Math.max(n, max);
		}
		return max;
	}
	
	public void traverse(Map<Integer, List<int[]>> map, int[] cost, int s, int parent) {
		if (cost[s] == -1 || cost[s] > parent) {
			cost[s] = parent;
		} else {
			return;
		}
		if (map.containsKey(s)) {
			for (int[] t : map.get(s)) {
				traverse(map, cost, t[0], parent + t[1]);
			}
		}
	}

}
