package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int shortestDistance(String[] words, String word1, String word2) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) {
				List<Integer> list = new ArrayList<>();
				map.put(words[i], list);
			}
			map.get(words[i]).add(i);
		}

		List<Integer> aList = map.get(word1);
		List<Integer> bList = map.get(word2);
		int min = Integer.MAX_VALUE;
		for (int a : aList) {
			for (int b : bList) {
				if(a==b){
					continue;
				}
				min = Math.min(min, Math.abs(b - a));
			}
		}

		return min;
	}

}
