package com.lee.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule207 {
	public static void main(String[] args) {
		CourseSchedule207 obj = new CourseSchedule207();
		 System.out.println(obj.canFinish(2, new int[][]{ new int[]{1,0}}));
//		System.out.println(obj.canFinish(2, new int[][] { new int[] { 1, 0 } }));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// a->b
		int count = 0;
		Map<Integer, List<Integer>> parent = new HashMap<>();
		Map<Integer, List<Integer>> children = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			set.add(i);
			parent.put(i, new ArrayList<Integer>());
			children.put(i, new ArrayList<Integer>());
		}
		for (int[] p : prerequisites) {
			parent.get(p[1]).add(p[0]);
			children.get(p[0]).add(p[1]);
			set.remove(p[0]);
		}

		while (!set.isEmpty()) {
			List<Integer> t = new ArrayList<>();
			t.addAll(set);
			System.out.println(Arrays.toString(set.toArray()));
			set.clear();
			for (int i : t) {
				System.out.println(parent.toString() + "  " + children.toString() + "   " + i);
				count++;
				if(count>=numCourses){
					return true;
				}
				
				
				List<Integer> child = parent.get(i);
				if (child != null && child.size() > 0) {
					for (int j : child) {
						children.get(j).remove((Object) i);
						if (children.get(j).size() == 0) {
							set.add(j);
						}
					}
				}
			}
		}

		return false;
	}
}
