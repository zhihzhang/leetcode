package com.lee.againt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickwithWeight {

	public static void main(String[] args) {
//		 long[] t = new long[]{1,3,5,7};
//		 int i = Arrays.binarySearch(t, 2);
//		 System.out.println(i);
		int[] w = new int[] { 10, 40, 50 };
		RandomPickwithWeight obj = new RandomPickwithWeight(w);
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			int c = obj.pickIndex();
			map.put(c, map.getOrDefault(c, 0)+1);
//			System.out.println(obj.pickIndex());
		}
		System.out.println(map.toString());
	}

	int[] r;
	Random random;

	public RandomPickwithWeight(int[] w) {
		r = new int[w.length];
		r[0] = w[0];
		for (int i = 1; i < w.length; i++) {
			r[i] = r[i - 1] + w[i];
		}
		System.out.println(Arrays.toString(r));
		random = new Random();
	}

	public int pickIndex() {
		int v = random.nextInt(r[r.length - 1]) + 1;
		int t = Arrays.binarySearch(r, v);
		if (t >= 0) {
			return t;
		} else {
			t = -t;
			t = t - 1;
			return t;
		}
	}

}
