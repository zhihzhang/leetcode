package com.lee.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII253 {
	public static void main(String[] args) {
		MeetingRoomsII253 obj = new MeetingRoomsII253();
		Interval[] intervals = new Interval[3];
		Interval a01 = new Interval(1,5);
		Interval a02 = new Interval(8,9);
		Interval a03 = new Interval(8,9);
		
		intervals[0] = a01;
		intervals[1] = a02;
		intervals[2] = a03;
		int r = obj.minMeetingRooms(intervals);
		System.out.println(r);

	}
	
	
	
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Queue<Interval> queue = new PriorityQueue<>((a,b)->(a.start-b.start));
		for (Interval i : intervals) {
			queue.add(i);
		}
		Queue<Interval> endQueue = new PriorityQueue<>((a,b)->(a.end-b.end));
		int count = 0;
		while(!queue.isEmpty()){
			Interval i = queue.poll();
			if(endQueue.isEmpty() || endQueue.peek().end > i.start){
				endQueue.offer(i);
				count = Math.max(count, endQueue.size());
				continue;
			}
			while(!endQueue.isEmpty() && endQueue.peek().end <= i.start){
				endQueue.poll();
			}
			endQueue.offer(i);
		}
		
		return count;
	}
	
	
//	public int minMeetingRooms123(Interval[] intervals) {
//		if (intervals == null || intervals.length == 0) {
//			return 0;
//		}
//		Queue<Interval> queue = new PriorityQueue<>((a,b)->(a.start-b.start));
//		for (Interval i : intervals) {
//			queue.add(i);
//		}
//		int min = 1;
//		int l = 0;
//		int r = 0;
//		Interval i = queue.poll();
//		l = i.start;
//		r = i.end;
//
//		int count = 1;
//		while (!queue.isEmpty()) {
//			i = queue.poll();
//			if (i.end < r) {
//				r = Math.min(r, i.end);
//				count++;
//			} else {
//				min = Math.max(count, min);
//				count = 0;
//				l = i.start;
//				r = i.end;
//			}
//		}
//		return min;
//	}
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