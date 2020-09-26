package com.lee.aathird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleTwo {

	public static void main(String[] args) {
		CourseScheduleTwo obj = new CourseScheduleTwo();
		int[] a = obj.findOrder(3, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 } });
		System.out.println(Arrays.toString(a));

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, List<Integer>> map = new HashMap<>(); // dependency
		for (int i = 0; i < prerequisites.length; i++) {
			if (!graph.containsKey(prerequisites[i][1])) {
				graph.put(prerequisites[i][1], new ArrayList<>());
			}
			if (!map.containsKey(prerequisites[i][0])) {
				map.put(prerequisites[i][0], new ArrayList<>());
			}
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
			map.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		List<Integer> list = new ArrayList<>();
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!map.containsKey(i)) {
				queue.add(i);
				list.add(i);
			}
		}

		while (!queue.isEmpty() && list.size() < numCourses) {
			int l = queue.size();
			for (int i = 0; i < l; i++) {
				int n = queue.poll();
				i++;
				if (graph.containsKey(n)) {
					for (int v : graph.get(n)) {
						map.get(v).remove((Object)n);
						if (map.get(v).isEmpty()) {
							if (!list.contains(v)) {
								queue.add(v);
								list.add(v);
							}
						}
					}
				}
			}
		}
		if(list.size()<numCourses){
			return new int[]{};
		}
		int[] r = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			r[i] = list.get(i);
		}
		return r;
	}

}
