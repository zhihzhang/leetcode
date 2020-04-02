package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<String, List<Integer>> map = new HashMap<>();
	Map<String, Integer> cache = new HashMap<>();
	
    public ShortestWordDistanceII(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) {
				List<Integer> list = new ArrayList<>();
				map.put(words[i], list);
			}
			map.get(words[i]).add(i);
		}
    }
    
    public int shortest(String word1, String word2) {
    	Integer t = getFromCache(word1, word2);
    	if(t!=null){
    		return t;
    	}
    	
		List<Integer> aList = map.get(word1);
		List<Integer> bList = map.get(word2);
		int min = Integer.MAX_VALUE;
		for (int a : aList) {
			for (int b : bList) {
				min = Math.min(min, Math.abs(b - a));
			}
		}
		
		putCache(word1, word2, min);

		return min;
    }
    
    public Integer getFromCache(String word1, String word2){
    	List<String> list = new ArrayList<>();
    	list.add(word1);
    	list.add(word2);
    	Collections.sort(list);
    	return cache.get(list.toString());
    }
    
    public void putCache(String word1, String word2, int v){
    	List<String> list = new ArrayList<>();
    	list.add(word1);
    	list.add(word2);
    	Collections.sort(list);
    	cache.put(list.toString(), v);
    }

}
