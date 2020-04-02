package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleII {

	public static void main(String[] args) {
		CourseScheduleII obj = new CourseScheduleII();
		int[] w = new int[]{1,0};
		int[][] p = new int[1][2];
		p[0]=w;
		int[] t = obj.findOrder(2, p);
		System.out.println(Arrays.toString(t));
	}

	Set<Integer> failed = new HashSet<>();

	public boolean dfs(Map<Integer, List<Integer>> map, int s, List<Integer> path, int n) {
		if (path.contains(s)) {
			return false;
		}
		
		if (path.size() == n-1) {
			path.add(s);
			return true;
		}
		if(!map.containsKey(s)){
			return false;
		}
		path.add(s);
		for (int v : map.get(s)) {
			if (failed.contains(v)) {
				continue;
			}
			boolean f = dfs(map, v, path, n);
			if (f) {
				return true;
			} else {
				failed.add(v);
			}
		}
		path.remove(path.size()-1);
		return false;

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> rootList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			rootList.add(i);
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] p : prerequisites) {
			if (!map.containsKey(p[1])) {
				map.put(p[1], new ArrayList<Integer>());
			}
			map.get(p[1]).add(p[0]);
			rootList.remove((Object)p[0]);
		}
		System.out.println(rootList.toString());
		if (rootList.isEmpty()) {
			return new int[] {};
		}
		List<Integer> path = new ArrayList<>();
		for (int s : rootList) {
			boolean f = dfs(map, s, path, numCourses - rootList.size() + 1);
			System.out.println(s + "...." + f) ;
			if (f) {
				int[] r = new int[numCourses];
				rootList.remove((Object)s);
				path.addAll(rootList);
				for (int i = 0; i < path.size(); i++) {
					r[i] = path.get(i);
				}
				return r;
			}
		}
		return new int[] {};
	}

}
