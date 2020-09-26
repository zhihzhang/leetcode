package com.lee.aathird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakTwo {

	public static void main(String[] args) {
		WordBreakTwo obj = new WordBreakTwo();
		String s = "pineapplepenapple";
		String[] array = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
		List<String> wordDict = new ArrayList<>();
		for(String a:array){
			wordDict.add(a);
		}
		System.out.println(obj.wordBreak(s, wordDict));
	}

	
	Map<String, List<List<String>>> cache = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		List<List<String>> result = wb(s, wordDict);
		List<String> list = new ArrayList<>();
		for(List<String> x:result){
			list.add(toString(x));
		}
		return list;
	}

	public List<List<String>> wb(String s, List<String> dict) {
		if(cache.containsKey(s)){
			return cache.get(s);
		}
		List<List<String>> result = new ArrayList<>();
		for (String d : dict) {
			if (s.equals(d)) {
				List<String> list = new ArrayList<>();
				list.add(s);
				result.add(list);
			} else if (s.startsWith(d)) {
				String t = s.substring(d.length(), s.length());
				List<List<String>> r = wb(t, dict);
				for(List<String> l:r){
					List<String> list = new ArrayList<>();
					list.add(d);
					list.addAll(l);
					result.add(list);
				}
			}
		}
		cache.put(s, result);
		return result;
	}

	public String toString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size()-1; i++) {
			sb.append(list.get(i)).append(" ");
		}
		sb.append(list.get(list.size()-1));
		return sb.toString();
	}

}
