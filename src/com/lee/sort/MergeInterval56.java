package com.lee.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval56 {

	public static void main(String[] args) {
		MergeInterval56 obj = new MergeInterval56();
		List<Interval> ans = new ArrayList<>();
		ans.add(new Interval(1, 3));
		ans.add(new Interval(2, 6));
		ans.add(new Interval(8, 10));
		ans.add(new Interval(15, 18));
		List<Interval> r = obj.merge(ans);
		System.out.println(r.size());
	}
	
    public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new ArrayList<>();
		if (intervals == null || intervals.isEmpty()) {
			return ans;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		Interval head = null;
		for (Interval i : intervals) {
			if (head == null) {
				head = i;
				continue;
			}
			if (head.end >= i.start) {
				head.end = Math.max(head.end, i.end);
			} else {
				ans.add(head);
				head = i;
			}
		}
		if(!ans.contains(head)){
			ans.add(head);
		}
		return ans;
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
