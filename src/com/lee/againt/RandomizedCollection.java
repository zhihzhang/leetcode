package com.lee.againt;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomizedCollection {

	public static void main(String[] args) {
		RandomizedCollection obj = new RandomizedCollection();
		obj.insert(1);
		obj.insert(10);
		obj.insert(10);
		obj.insert(100);
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}
	
	
	TreeMap<Integer,Integer> map = new TreeMap<>();
	TreeMap<Integer,Integer> randomMap = new TreeMap<>();
	int seed = 0;
	Random r = new Random();
	boolean shouldRefresh = false;
	
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
		map.put(val, map.getOrDefault(val, 0) + 1);
		shouldRefresh = true;
		return map.get(val) == 1 ? true : false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			map.put(val, map.get(val) - 1);
			if (map.get(val) == 0) {
				map.remove(val);
			}
			shouldRefresh = true;
			return true;
		}
		return false;
	}
	
	private void generateRandom(){
		randomMap.clear();
		int k = 0;
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			randomMap.put(k, entry.getKey());
			k += entry.getValue();
		}
		seed = k;
	}
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	if(map.size()==0){
    		return 0;
    	}
    	if(shouldRefresh){
    		generateRandom();
    		shouldRefresh = false;
    	}
    	int t = r.nextInt(seed);
    	return randomMap.floorEntry(t).getValue();
    }

}
