package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class OddEvenJump {

	public static void main(String[] args) {
		OddEvenJump obj = new OddEvenJump();
		System.out.println(obj.oddEvenJumps(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(obj.oddEvenJumps(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(obj.oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));
		System.out.println(obj.oddEvenJumps(new int[] { 1,2,3,2,1,4,4,5}));
//		
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		map.put(4, 7);
//		map.put(5, 7);
//		map.put(6, 7);
//		System.out.println(map.higherEntry(5));
//		System.out.println(map.higherEntry(6));
	}

	public int oddEvenJumps(int[] A) {
		if (A.length < 2) {
			return A.length;
		}
		int[] odd = new int[A.length];
		int[] even = new int[A.length];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		odd[A.length - 1] = 1;
		even[A.length - 1] = 1;
		map.put(A[A.length - 1], A.length - 1);
		int count = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			int d = A[i];
			
			if (map.containsKey(d)) {
				odd[i] = even[map.get(d)];
				even[i] = odd[map.get(d)];
			} else {
				Integer h = map.higherKey(d);
				Integer l = map.lowerKey(d);
				if (l == null) {
					odd[i] = even[map.get(h)];
				} else if (h == null) {
					even[i] = odd[map.get(l)];
				} else {
					odd[i] = even[map.get(h)];
					even[i] = odd[map.get(l)];
				}
			}
			map.put(d, i);
			count = count + odd[i];
		}

		return count;
	}

	public int oddEvenJumps123(int[] A) {
		if (A.length < 2) {
			return A.length;
		}
		int[] odd = new int[A.length];
		int[] even = new int[A.length];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		odd[A.length - 1] = 1;
		even[A.length - 1] = 1;
		map.put(A[A.length - 1], A.length - 1);
		for (int i = A.length - 2; i >= 0; i--) {
			int d = A[i];
			Set<Integer> set = map.keySet();
			int min = Integer.MIN_VALUE;

			int tv = 0;

			// binary search
			// if it doesn't contain
			for (int v : set) {
				tv = v;
				if (v < d) {
					min = v;
					continue;
				}
				if (v == d) {
					odd[i] = even[map.get(v)];
					even[i] = odd[map.get(v)];
					break;
				}
				if (v > d) {
					odd[i] = even[map.get(v)];
					if (min != Integer.MIN_VALUE) {
						even[i] = odd[map.get(min)];
					}
					break;
				}
			}
			if (tv < d) {
				even[i] = odd[map.get(tv)];
			}
			map.put(d, i);
		}
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (odd[i] == 1) {
				count++;
			}
		}
		return count;
	}

}
