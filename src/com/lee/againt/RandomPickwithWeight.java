package com.lee.againt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

import javafx.scene.control.TreeCell;

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

	TreeMap<Integer,Integer> map = new TreeMap<>();
	Random random = new Random();
	int sum = 0;

	public RandomPickwithWeight(int[] w) {
		int i=0;
		for (int n : w) {
			map.put(sum, i++);
			sum += n;
		}
	}

	public int pickIndex() {
		int r = random.nextInt(sum);
		return map.floorEntry(r).getValue();
	}

}
