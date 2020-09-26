package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// [[1,3],[6,9]]
	// [2,5]
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int start = newInterval[0];
		int end = newInterval[1];
		List<int[]> list = new ArrayList<>();
		int i = 0;

		while (i < intervals.length && intervals[i][1] < start) {
			list.add(new int[] { intervals[i][0], intervals[i][1] });
			i++;
		}
		while (i < intervals.length && intervals[i][0] < end) {
			start = Math.min(start, intervals[i][0]);
			end = Math.max(end, intervals[i][1]);
			i++;
		}
		list.add(new int[] { start, end });
		while (i < intervals.length) {
			list.add(new int[] { intervals[i][0], intervals[i][1] });
			i++;
		}

		int[][] r = new int[list.size()][2];
		for (int j = 0; j < list.size(); j++) {
			r[j] = list.get(j);
		}
		return r;
	}

}
