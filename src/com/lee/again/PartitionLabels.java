package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionLabels {

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij").toString());

	}

	public List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
		}

		int i = 0;
		int count = 0;
		int r = 0;
		Set<Character> set = new HashSet<>();
		while (i < S.length()) {
			char c = S.charAt(i);
			set.add(c);
			if (map.get(c) == i) {
				count++;
			}
			r++;
			if (count == set.size()) {
				list.add(r);
				set.clear();
				count = 0;
				r = 0;
			}
			i++;

		}

		return list;
	}

}
