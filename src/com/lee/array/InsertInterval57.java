package com.lee.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval57 {

	public static void main(String[] args) {
		InsertInterval57 obj = new InsertInterval57();

	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> list = new ArrayList<Interval>();
		int start = newInterval.start;
		int end = newInterval.end;
		
		boolean ifAddNew = true;
		
		for (Interval e : intervals) {
			if (e.end < start) {
				list.add(e);
				continue;
			}
			if (e.start > end) {
				list.add(e);
				continue;
			}
			
			if (start >= e.start) {
				newInterval.start = e.start;
//				isOverLap = true;

				if (end <= e.end) {
					ifAddNew = false;
					list.add(e);
					continue;
				}
			}
			
			if (end >= e.start && end <= e.end) {
				newInterval.end = e.end;
			}
		}
		
		if (ifAddNew) {
			list.add(newInterval);
		}
		
		Collections.sort(list, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
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
