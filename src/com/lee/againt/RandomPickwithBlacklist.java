package com.lee.againt;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class RandomPickwithBlacklist {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> t = new TreeMap<>();
		t.put(1, 1);
		t.put(3, 3);
		System.out.println(t.floorEntry(2));
		System.out.println(t.ceilingEntry(2));
		System.out.println(t.floorEntry(1));
		
		RandomPickwithBlacklist obj = new RandomPickwithBlacklist(4, new int[]{0,1});
		System.out.println("#######....." + obj.pick());
		System.out.println("#######....." + obj.pick());
		System.out.println("#######....." + obj.pick());
		System.out.println("#######....." + obj.pick());
		System.out.println("#######....." + obj.pick());
		System.out.println("#######....." + obj.pick());

	}

	int sum = 0;
	Random random = new Random();
	TreeMap<Integer, Integer> map = new TreeMap<>();

	public RandomPickwithBlacklist(int N, int[] blacklist) {
		sum = N - blacklist.length;
		for (int n : blacklist) {
			map.put(n, -1);
		}
		int i = sum;
		for (int n : blacklist) {
			if (n < sum) {
				while (map.containsKey(i)) {
					i++;
				}
				map.put(n, i++);
			}
		}
	}

	public int pick() {
		int r = random.nextInt(sum);
		if (map.containsKey(r)) {
			return map.get(r);
		}
		return r;
	}

}
