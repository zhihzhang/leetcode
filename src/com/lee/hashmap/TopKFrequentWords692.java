package com.lee.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentWords692 {

	public static void main(String[] args) {
		TopKFrequentWords692 obj = new TopKFrequentWords692();
		String[] a = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
		System.out.println(obj.topKFrequent(a, 2).toString());
	}
	
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		
		Map<Integer, List<String>> treeMap = new TreeMap<>(Collections.reverseOrder());
		for(Map.Entry<String, Integer> entry:map.entrySet()){
			if(!treeMap.containsKey(entry.getValue())){
				List<String> list = new ArrayList<>();
				treeMap.put(entry.getValue(), list);
			}
			treeMap.get(entry.getValue()).add(entry.getKey());
		}
		
		List<String> list = new ArrayList<>();
		for(Map.Entry<Integer, List<String>> entry:treeMap.entrySet()){
			List<String> t = entry.getValue();
			Collections.sort(t);
			for(String s : t){
				list.add(s);
				if(list.size()==k){
					return list;
				}
			}
		}
		return list;
	}

}
