package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> list = new ArrayList<>();
		if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0){
			return list;
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>(
				(a, b) -> ((nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])));
		for (int i = 0; i < k && i < nums1.length; i++) {
			queue.add(new int[] { i, 0 });
		}
		int c = 0;
		while (!queue.isEmpty()) {
			int[] a = queue.poll();
			List<Integer> r = new ArrayList<>();
			r.add(nums1[a[0]]);
			r.add(nums2[a[1]]);
			list.add(r);
			c++;
			if (c == k) {
				return list;
			}
			int x = a[0];
			int y = a[1];
			if (y < nums2.length - 1) {
				queue.add(new int[] { x, y + 1 });
			}
		}
		return list;
	}

}
