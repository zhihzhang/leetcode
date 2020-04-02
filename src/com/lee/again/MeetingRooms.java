package com.lee.again;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canAttendMeetings(int[][] intervals) {
		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		for (int[] t : intervals) {
			queue.add(t);
		}
		while (!queue.isEmpty()) {
			int[] meeting01 = queue.poll();
			if (queue.isEmpty()) {
				return true;
			}
			int[] meeting02 = queue.peek();
			if (meeting02[0] < meeting01[1]) {
				return false;
			}
		}
		return true;
	}

}
