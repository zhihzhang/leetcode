package com.lee.again;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> restoreIpAddresses(String s) {
		Map<String, List<String>> cache = new HashMap<>();
		return getAddress(s, cache, 4);
	}

	public List<String> getAddress(String s, Map<String, List<String>> cache, int n) {
		if (cache.containsKey(s)) {
			return cache.get(s);
		}
		List<String> list = new ArrayList<String>();
		if (n == 1) {
			int v = Integer.valueOf(s);
			if (v >= 0 && v < 256) {
				list.add(s);
				cache.put(s, list);
				return list;
			}
		} else {
			for (int i = 1; i <= 3; i++) {
				;
			}
		}
		return null;
	}

}
