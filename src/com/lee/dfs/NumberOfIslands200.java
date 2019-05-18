package com.lee.dfs;

public class NumberOfIslands200 {
	public static void main(String[] args) {
		NumberOfIslands200 obj = new NumberOfIslands200();
	}

	private int[][] seen;
	private int count = 0;

	public void traverse(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == '1' && seen[i][j] == 0) {
			seen[i][j] = 1;

			traverse(grid, i + 1, j);
			traverse(grid, i - 1, j);
			traverse(grid, i, j - 1);
			traverse(grid, i, j + 1);
		}
	}

	public int numIslands(char[][] grid) {
		if(grid.length==0){
			return 0;
		}
		seen = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && seen[i][j] == 0) {
					count++;
				}
				traverse(grid, i, j);
			}
		}

		return count;
	}
	
	
//	int parent[];
//	int size[];
//	int count = 0;
//	List<Integer> nList = new ArrayList<Integer>();
//
//	public int numIslands(char[][] grid) {
//		if(grid==null || grid.length==0){
//			return 0;
//		}
//		int rowSize = grid[0].length;
//		count = grid.length * grid[0].length;
//		parent = new int[count];
//		size = new int[count];
//		
//		count = 0;
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < rowSize; j++) {
//				int v = i * rowSize + j;
//				parent[v] = v;
//				size[v] = 1;
//				if (grid[i][j] == '1') {
//					count ++;
//				}
//			}
//		}
//
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < rowSize; j++) {
//				if (grid[i][j] == '0') {
//					continue;
//				}
//				int v = i * rowSize + j;
//				int ai = i - 1;
//				int aj = j - 1;
//				if (ai >= 0 && grid[ai][j] == '1') {
//					join(ai * rowSize + j, v);
//				}
//				if (aj >= 0 && grid[i][aj] == '1') {
//					join(i * rowSize + aj, v);
//				}
//			}
//		}
//
//		return count;
//	}
//
//	public int find(int v) {
//		while (v != parent[v]) {
//			parent[v] = parent[parent[v]];
//			v = parent[v];
//		}
//		return v;
//	}
//
//	public void join(int a, int b) {
//		int i = find(a);
//		int j = find(b);
//		if (i == j) {
//			return;
//		}
//
//		if (size[i] < size[j]) {
//			parent[i] = j;
//			size[j] += size[i];
//		} else {
//			parent[j] = i;
//			size[i] += size[j];
//		}
//		
//		count--;
//	}
}
