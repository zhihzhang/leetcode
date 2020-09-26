package com.lee.aafour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

	public static void main(String[] args) {
		MinimumGeneticMutation obj = new MinimumGeneticMutation();
		String[] bank = new String[] { "AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA" };
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		int n = obj.minMutation(start, end, bank);
		System.out.println("Result is " + n);
	}

	public int minMutation(String start, String end, String[] bank) {
		if(start.equals(end)){
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		Set<String> visisted = new HashSet<>();
		visisted.add(start);
		queue.add(start);
		int step = 1;
		while (!queue.isEmpty()) {
			int l = queue.size();
			for (int i = 0; i < l; i++) {
				String s = queue.poll();
				for (String b : bank) {
					if (visisted.contains(b)) {
						continue;
					}
					if (diff(s, b)) {
						if(b.equals(end)){
							return step;
						}
						queue.offer(b);
						visisted.add(b);
					}
				}
			}
			step++;
		}
		return -1;
	}

	public boolean diff(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1;
	}

}
