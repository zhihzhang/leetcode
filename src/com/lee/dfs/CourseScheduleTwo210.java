package com.lee.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleTwo210 {
	public static void main(String[] args){
		CourseScheduleTwo210 obj = new CourseScheduleTwo210();
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
	    int[] incLinkCounts = new int[numCourses];
	    List<List<Integer>> adjs = new ArrayList<>(numCourses);
	    initialiseGraph(incLinkCounts, adjs, prerequisites);
	    //return solveByBFS(incLinkCounts, adjs);
//	    return solveByDFS(adjs);
	    return null;
	}
	
	private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
	    int n = incLinkCounts.length;
	    while (n-- > 0) adjs.add(new ArrayList<>());
	    for (int[] edge : prerequisites) {
	        incLinkCounts[edge[0]]++;
	        adjs.get(edge[1]).add(edge[0]);
	    }
	}
	
	private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
	    int[] order = new int[incLinkCounts.length];
	    Queue<Integer> toVisit = new ArrayDeque<>();
	    for (int i = 0; i < incLinkCounts.length; i++) {
	        if (incLinkCounts[i] == 0) toVisit.offer(i);
	    }
	    int visited = 0;
	    while (!toVisit.isEmpty()) {
	        int from = toVisit.poll();
	        order[visited++] = from;
	        for (int to : adjs.get(from)) {
	            incLinkCounts[to]--;
	            if (incLinkCounts[to] == 0) toVisit.offer(to);
	        }
	    }
	    return visited == incLinkCounts.length ? order : new int[0]; 
	}
	
}
