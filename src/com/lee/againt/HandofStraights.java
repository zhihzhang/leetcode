package com.lee.againt;

import java.util.TreeMap;

public class HandofStraights {

	public static void main(String[] args) {
		HandofStraights obj = new HandofStraights();
		System.out.println(obj.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8, 9, 9 ,10 }, 4));

	}

	// 1,2,3,6,2,3,4,7,8
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand == null || W == 0) {
			return false;
		}
		int c = hand.length;
		if (c == 0) {
			return true;
		}
		if (c % W != 0) {
			return false;
		}

		TreeMap<Integer, Integer> counter = new TreeMap<>();
		for (int n : hand) {
			counter.put(n, counter.getOrDefault(n, 0) + 1);
		}

		for (int k : counter.keySet()) {
			if (counter.get(k) == 0) {
				continue;
			} else {
				int c01 = counter.get(k);
				counter.put(k, 0);
				for (int i = 1; i < W; i++) {
					int c02 = counter.getOrDefault(k + i, 0);
					if (c02 < c01) {
						return false;
					}
					counter.put(k + i, c02 - c01);
				}
			}
		}
		return true;

	}

}
