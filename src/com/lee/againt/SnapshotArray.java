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
	
	int snapId = 0;
	Map<Integer, Map<Integer, Integer>> history = new HashMap<>();
	Map<Integer, Integer> map = new HashMap<>();
	
    public SnapshotArray(int length) {
    }
    
    public void set(int index, int val) {
    	map.put(index, val);
    }
    
    public int snap() {
    	Map<Integer, Integer> snap = new HashMap<>(map); 
    	System.out.println(snap.toString());
    	history.put(snapId, snap);
    	return snapId++;
    }
    
    public int get(int index, int snap_id) {
    	if(!history.containsKey(index)){
    		return 0;
    	}
    	return history.get(snap_id).getOrDefault(index, 0);
    }

}
