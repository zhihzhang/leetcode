package com.lee.againt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
//		System.out.println(obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(obj.longestConsecutive(new int[]{-1,1,2,0}));

	}

	Map<Integer, Integer> root = new HashMap<>();
	Map<Integer, Integer> size = new HashMap<>();
	int max = 0;

	public int find(int n) {
		while (root.get(n) != n) {
			root.put(n, root.get(root.get(n)));
			n = root.get(n);
		}
		return n;
	}

	public void join(int a, int b) {
		int x = find(a);
		int y = find(b);
		int sizea = size.get(x);
		int sizeb = size.get(y);
		
		root.put(y, x);
		size.put(x, sizea + sizeb);
		size.put(y, sizea + sizeb);
		
		max = Math.max(max, sizea + sizeb);
	}

	public boolean connect(int a, int b) {
		return find(a) == find(b);
	}

	public int longestConsecutive(int[] nums) {
		for (int n : nums) {
			root.put(n, n);
			size.put(n, 1);
			max = 1;
		}

		for (int n : nums) {
			if (root.containsKey(n - 1) && !connect(n - 1, n)) {
				join(n, n - 1);
			}
			if (root.containsKey(n + 1) && !connect(n + 1, n)) {
				join(n, n + 1);
			}
		}

		return max;

	}

}
