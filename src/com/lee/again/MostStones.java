package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MostStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeStones(int[][] stones) {
		Map<Integer, List<int[]>> row = new HashMap<>();
		Map<Integer, List<int[]>> column = new HashMap<>();

		for (int[] stone : stones) {
			if (!row.containsKey(stone[0])) {
				row.put(stone[0], new ArrayList<int[]>());
			}
			if (!column.containsKey(stone[1])) {
				column.put(stone[1], new ArrayList<int[]>());
			}
			row.get(stone[0]).add(stone);
			column.get(stone[1]).add(stone);
		}

		Set<int[]> visited = new HashSet<>();
		int num = 0;
		for (int[] stone : stones) {
			if (visited.contains(stone)) {
				continue;
			}
			visited.add(stone);
			visit(visited, row, column, stone);
			num++;

		}
		return stones.length - num;
	}

	public void visit(Set<int[]> visited, Map<Integer, List<int[]>> row, Map<Integer, List<int[]>> column, int[] stone) {
		for (int[] s : row.get(stone[0])) {
			if (!visited.contains(s)) {
				visited.add(s);
				visit(visited, row, column, s);
			}
		}
		for (int[] s : column.get(stone[1])) {
			if (!visited.contains(s)) {
				visited.add(s);
				visit(visited, row, column, s);
			}
		}
	}

}
