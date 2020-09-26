package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindandReplacePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<>();
		for(String w:words){
			if(match(w, pattern)){
				list.add(w);
			}
		}
		return list;
	}

	public boolean match(String w, String p) {
		if (w.length() != p.length()) {
			return false;
		}
		Map<Character, Integer> a = new HashMap<>();
		Map<Character, Integer> b = new HashMap<>();
		for (int i = 0; i < w.length(); i++) {
			char c0 = w.charAt(i);
			char c1 = p.charAt(i);
			if (!a.containsKey(c0)) {
				a.put(c0, i);
			}
			if (!b.containsKey(c1)) {
				b.put(c1, i);
			}
			if (!(a.get(c0) == b.get(c1))) {
				return false;
			}
		}
		return true;
	}

}
