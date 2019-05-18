package com.lee.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII140 {

	public static void main(String[] args) {
		WordBreakII140 obj = new WordBreakII140();
		String s = "123133";
		String w = "123";
		System.out.println(s.substring(w.length() - 1));
	}

	List<List<String>> result = new ArrayList<>();
	Map<String, List<List<String>>> map = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> pre = new ArrayList<>();
		wb(s, wordDict, pre);

		List<String> l = new ArrayList<>();
		for (List<String> t : result) {

			String ss = String.join(" ", t);
			l.add(ss);
		}

		return l;
	}

	public List<List<String>> wb(String s, List<String> wordDict, List<String> pre) {
		if(map.containsKey(s)){
			for(List<String> x : map.get(s)){
				List<String> xl = new ArrayList<>();
				xl.addAll(pre);
				xl.addAll(x);
				result.add(xl);
			}
			return map.get(s);
		}
		List<List<String>> list = new ArrayList<>();
		for (String w : wordDict) {
			if (s.equals(w)) {
				List<String> t = new ArrayList<>();
				t.addAll(pre);
				t.add(w);
				result.add(t);
				
				List<String> tl = new ArrayList<>();
				tl.add(s);
				list.add(tl);
			} else if (s.startsWith(w)) {
				String x = s.substring(w.length());
				List<String> t = new ArrayList<>();
				t.addAll(pre);
				t.add(w);
				List<List<String>> tll = wb(x, wordDict, t);
				map.put(x, tll);
				for(List<String> tl : tll){
					List<String> xl = new ArrayList<>();
					xl.add(w);
					xl.addAll(tl);
					list.add(xl);
				}
			}
		}
		return list;
	}
}
