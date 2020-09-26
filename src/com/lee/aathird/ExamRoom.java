package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ExamRoom {

	public static void main(String[] args) {
	}

	TreeSet<Integer> set = new TreeSet<>();
	int n = 0;

	public ExamRoom(int N) {
		n = N;
		set.add(n);
	}

	public int seat() {
		if (set.size() == 1) {
			set.add(0);
			return 0;
		} else if (set.size() == 2) {
			if (set.first() >= n / 2) {
				set.add(0);
				return 0;
			} else {
				set.add(n-1);
				return n - 1;
			}
		} else {
			List<Integer> list = new ArrayList<>();
			list.addAll(set);
			int max = 0;
			int idx = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				int l = list.get(i);
				int r = list.get(i + 1);
				if (r - l > max) {
					idx = l;
					max = r - l;
				}
			}
			int i = idx + (max / 2);
			set.add(i);
			return i;
		}
	}

	public void leave(int p) {
		set.remove((Object) p);
	}

}
