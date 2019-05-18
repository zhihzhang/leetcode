package com.lee.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class NumberofDistinctIslandsII711 {

	public static void main(String[] args) {
		NumberofDistinctIslandsII711 obj = new NumberofDistinctIslandsII711();
		
		int[][] grid = new int[][]{
//			{1,1,0,0,0},
//			{1,0,0,0,0},
//			{0,0,0,0,1},
//			{0,0,0,1,1}
			
			{1,1,0},
			{0,1,1},
			{0,0,0},
			{1,1,1},
			{0,1,0}
		};
		System.out.println(obj.numDistinctIslands2(grid));

//		Set<Map<Integer, Integer>> set = new HashSet<>();
//		Map<Integer, Integer> a = new TreeMap<>();
//		a.put(1, 3);
//		a.put(5, 4);
//		set.add(a);
//
//		Map<Integer, Integer> b = new TreeMap<>();
//		b.put(1, 3);
//		b.put(5, 4);
//
//		System.out.println(a.equals(b));
//		System.out.println(set.contains(b));
	}

	int[][] seen;
	Set<Map<Integer, Integer>> set = new HashSet<>();

	public void explore(int[][] grid, int r, int c, int di, List<Integer> list) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && seen[r][c] == 0 && grid[r][c] == 1) {
			seen[r][c] = 1;
			list.add(di);
			explore(grid, r - 1, c, 1, list);
			explore(grid, r + 1, c, 2, list);
			explore(grid, r, c - 1, 3, list);
			explore(grid, r, c + 1, 4, list);
		}
	}

	public void addIsland(List<Integer> list) {
		if(list.isEmpty()){
			return;
		}
		Map<Integer, Integer> map = new TreeMap<>();
		
		System.out.println("...." + list.toString());
		
		for (int v : list) {
			if (v == 0) {
				continue;
			}
			map.put(v, map.getOrDefault(v, 0) + 1);
		}
		List<Integer> temp = new ArrayList<>();
		temp.addAll(map.values());
		Collections.sort(temp);
		int i = 1;
		
		map.clear();
		for(int v : temp){
			map.put(i++, v);
		}
		
		System.out.println(map.toString());
		System.out.println("...." + set.contains(map));
		
		if(!set.contains(map)){
			set.add(map);
		}
	}

	public int numDistinctIslands2(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		seen = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<Integer> list = new ArrayList<>();
					explore(grid, i, j, 0, list);
					addIsland(list);
				}
			}
		}

		return set.size();
	}
	


}
