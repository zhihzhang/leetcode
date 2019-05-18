package com.lee.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {

	public static void main(String[] args) {
		WordLadder127 obj = new WordLadder127();
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		int s = obj.ladderLength("hit", "cog", wordList);
		System.out.println(s);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) {
			return 0;
		}
//    	Set<String> used = new HashSet<String>();
    	Map<String, Integer> stepMap = new HashMap<String, Integer>();
//		used.add(beginWord);
		stepMap.put(beginWord, 1);
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		while (!queue.isEmpty()) {
			String s = queue.poll();
			for (String e : wordList) {
				if (stepMap.containsKey(e)) {
					continue;
				}
				if (isDiff(s, e)) {
					if (e.equals(endWord)) {
						return stepMap.get(s) + 1;
					}
//					used.add(e);
					queue.add(e);
//					System.out.println("..." + e + "..." + (stepMap.get(s) + 1));
					stepMap.put(e, stepMap.get(s) + 1);
				}
			}
		}
    	
        return 0;
    }
    
	public boolean isDiff(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return (count == 1 ? true : false);
	}

}
