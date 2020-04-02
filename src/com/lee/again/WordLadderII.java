package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> list = new ArrayList<>();
		if (beginWord.equals(endWord)) {
			List<String> t = new ArrayList<>();
			t.add(beginWord);
			list.add(t);
			return list;
		}

		Set<String> visited = new HashSet<>();
		Queue<List<String>> queue = new LinkedList<>();
		List<String> head = Collections.singletonList(beginWord);
		queue.add(head);
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			if (!list.isEmpty()) {
				return list;
			}
			int size = queue.size();
			Set<String> set = new HashSet<>();
			for (int i = 0; i < size; i++) {
				List<String> sList = queue.poll();
				String start = sList.get(sList.size() - 1);
				for (String w : wordList) {
					if (!visited.contains(w) && diff(start, w)) {
						if (w.equals(endWord)) {
							List<String> t = new ArrayList<>();
							t.addAll(sList);
							t.add(w);
							list.add(t);
						} else if (!visited.contains(w)) {
							List<String> t = new ArrayList<>();
							t.addAll(sList);
							t.add(w);
							queue.add(t);
							set.add(w);
						}
					}

				}
			}
			visited.addAll(set);
		}
		return list;
	}

	
	Map<String, Boolean> cache = new HashMap<>();
	public boolean diff(String a, String b) {
		String key = a + ":::" + b;
		if(cache.containsKey(key)){
			return cache.get(key);
		}
		char[] ba = b.toCharArray();
		char[] aa = a.toCharArray();
		int count = 0;
		for (int i = 0; i < aa.length; i++) {
			char bc = ba[i];
			char ac = aa[i];
			if (bc != ac) {
				count++;
			}
			if (count > 1) {
				cache.put(key, false);
				return false;
			}
		}
		if (count == 1) {
			cache.put(key, true);
			return true;
		}
		cache.put(key, false);
		return false;
	}

}
