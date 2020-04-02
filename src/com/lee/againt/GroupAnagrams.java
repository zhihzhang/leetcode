package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> r = new ArrayList<>();
		Map<String, List<String>> t = new HashMap<>();
		for (String s : strs) {
			Map<Character, Integer> map = new HashMap<>();
			for (Character c : s.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			if (!t.containsKey(map.toString())) {
				t.put(map.toString(), new ArrayList<String>());
			}
			t.get(map.toString()).add(s);
		}
		r.addAll(t.values());
		return r;
	}

	
			
			
}
