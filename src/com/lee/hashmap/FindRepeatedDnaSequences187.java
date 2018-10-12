package com.lee.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindRepeatedDnaSequences187 {

	public static void main(String[] args) {
		FindRepeatedDnaSequences187 obj = new FindRepeatedDnaSequences187();
		List<String> list = obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println(list.toString());
		
		list = obj.findRepeatedDnaSequences("AAAAAAAAAAA");
		System.out.println(list.toString());
	}

	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String t = s.substring(i, i + 10);
			System.out.println(i + "..." + t);
			if(map.containsKey(t)){
				set.add(t);
			}else{
				map.put(t, 1);
			}
		}
		List<String> list = new ArrayList();
		list.addAll(set);
		return list;
	}

}
