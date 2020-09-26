package com.lee.aafour;

import java.util.PriorityQueue;
import java.util.Queue;

public class TrappingRainWaterII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sum = 0;

	public int trapRainWater(int[][] heightMap) {
		int[][] visited = new int[heightMap.length][heightMap[0].length];
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
		int x = heightMap.length;
		int y = heightMap[0].length;
		for (int j = 0; j < y; j++) {
			visited[0][j] = 1;
			visited[x - 1][j] = 1;
			queue.add(new int[] { 0, j, heightMap[0][j] });
			queue.add(new int[] { x - 1, j, heightMap[x - 1][j] });
		}
		for (int i = 1; i < x - 1; i++) {
			visited[i][0] = 1;
			visited[i][y - 1] = 1;
			queue.add(new int[] { i, 0, heightMap[i][0] });
			queue.add(new int[] { i, y - 1, heightMap[i][y - 1] });
		}
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			dfs(heightMap, visited, queue, arr[0], arr[1], arr[2], true);
		}
		return sum;
	}

	public void dfs(int[][] heightMap, int[][] visited, Queue<int[]> queue, int i, int j, int h, boolean isBfs) {
		if (i < 0 || j < 0 || i >= heightMap.length || j >= heightMap[0].length) {
			return;
		}
		if(!isBfs && visited[i][j]==1){
			return;
		}
		visited[i][j] = 1;
		if (heightMap[i][j] <= h) {
			sum += h - heightMap[i][j];
			dfs(heightMap, visited, queue, i - 1, j, h, false);
			dfs(heightMap, visited, queue, i + 1, j, h, false);
			dfs(heightMap, visited, queue, i, j - 1, h, false);
			dfs(heightMap, visited, queue, i, j + 1, h, false);
		} else if(!isBfs){
			queue.add(new int[] { i, j, heightMap[i][j] });
		}
	}

}
