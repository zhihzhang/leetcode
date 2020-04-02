package com.lee.again;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class TimeBasedKVStore981 {

	public static void main(String[] args) {
		TimeBasedKVStore981 obj = new TimeBasedKVStore981();

	}

	Map<String, TreeMap<Integer, String>> map = new HashMap<>();

	/** Initialize your data structure here. */
	public void TimeMap() {
		Queue<String> queue = new PriorityQueue<String>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

	}

	public void set(String key, String value, int timestamp) {
		map.putIfAbsent(key, new TreeMap<Integer, String>());
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> vMap = map.get(key);
		if (vMap == null) {
			return null;
		}
		Map.Entry<Integer, String> entry = vMap.floorEntry(timestamp);
		if (entry != null) {
			return entry.getValue();
		}
		return null;
	}

}
