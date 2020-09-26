package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class AllOne {

	public static void main(String[] args) {
//		AllOne obj = new AllOne();
		Map<Integer, Integer> a = new HashMap<>();
		Map<Integer, Integer> b = new HashMap<>();
		Map<Integer, Integer> c = new HashMap<>();
		
		b.put(1, 2);
		c.put(3, 4);
		a.putAll(b);
		a.putAll(c);
		System.out.println(a.toString());

	}


	/** Initialize your data structure here. */
	public AllOne() {

	}

	/**
	 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
	 */
	public void inc(String key) {
		
	}

	/**
	 * Decrements an existing key by 1. If Key's value is 1, remove it from the
	 * data structure.
	 */
	public void dec(String key) {
		
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		return null;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		return null;
	}

}
