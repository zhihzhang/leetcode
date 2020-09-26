package com.lee.againt;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {

	public static void main(String[] args) {
		SnapshotArray obj = new SnapshotArray(3);
		obj.set(0, 5);
		obj.snap();
		obj.set(0, 6);
		obj.snap();
		System.out.println(obj.get(0, 0));

	}

	Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	int snapId = 0;

	public SnapshotArray(int length) {
		Map<Integer, Integer> t = new HashMap<>();
		map.put(snapId, t);
	}

	public void set(int index, int val) {
		map.get(snapId).put(index, val);
	}

	public int snap() {
		Map<Integer, Integer> t = new HashMap<>();
		t.putAll(map.get(snapId));
		map.put(snapId + 1, t);
		return snapId++;
	}

	public int get(int index, int snap_id) {
		Map<Integer, Integer> t = map.get(snap_id);
		if (t != null) {
			return t.getOrDefault(index, 0);
		}
		return 0;
	}

}
