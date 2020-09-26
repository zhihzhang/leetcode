package com.lee.againt;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
	// Output: [[1,5],[6,9]]
	//
	// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval =
	// [4,8]
	// Output: [[1,2],[3,10],[12,16]]
	// Explanation: Because the new interval [4,8] overlaps with
	// [3,5],[6,7],[8,10].
	
	// [1,5] 
	// [2,3]
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		Queue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> (a[0] - b[0]));
		for (int[] i : intervals) {
			queue.offer(i);
		}
		List<int[]> list = new ArrayList<>();
		boolean newAdded = false;
		if(queue.isEmpty()){
			list.add(newInterval);
			newAdded = true;
		}

		
		while (!queue.isEmpty()) {
			int[] i = queue.poll();
			if (i[1] < newInterval[0]) {
				list.add(i);
			} else if (i[0] > newInterval[1]){
				list.add(newInterval);
				newAdded=true;
				list.add(i);
				while (!queue.isEmpty()) {
					list.add(queue.poll());
				}
			} else {
				int start = Math.min(i[0], newInterval[0]);
				int end = Math.max(i[1], newInterval[1]);
				boolean added = false;
				while (!queue.isEmpty()) {
					i = queue.poll();
					if (end < i[0]) {
						list.add(new int[]{start, end});
						list.add(i);
						added = true;
						break;
					} else {
						start = Math.min(i[0], start);
						end = Math.max(i[1], end);
					}
				}
				if(!added){
					list.add(new int[]{start, end});
				}
				while (!queue.isEmpty()) {
					list.add(queue.poll());
				}
				newAdded=true;
			}
		}
		if(!newAdded){
			list.add(newInterval);
		}
		int[][] t = new int[list.size()][2];
		int i = 0;
		for (int[] a : list) {
			t[i++] = a;
		}
		return t;
    }

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		Queue<Interval> queue = new PriorityQueue<>((Interval a, Interval b) -> (a.start - b.start));
		for (Interval i : intervals) {
			queue.offer(i);
		}
		List<Interval> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			Interval i = queue.poll();
			if (i.end < newInterval.start) {
				list.add(i);
			} else {
				int start = Math.min(i.start, newInterval.start);
				int end = Math.max(i.end, newInterval.end);
				while (!queue.isEmpty()) {
					i = queue.poll();
					if (end < i.start) {
						list.add(new Interval(start, end));
						list.add(i);
						break;
					} else {
						start = Math.min(i.start, start);
						end = Math.max(i.end, end);
					}
				}
				while (!queue.isEmpty()) {
					list.add(queue.poll());
				}
			}
		}
		return list;
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
