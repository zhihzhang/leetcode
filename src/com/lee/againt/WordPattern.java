package com.lee.againt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: pattern = "abba", str = "dog cat cat dog"
	// Output: true
	public boolean wordPattern(String pattern, String str) {
		String[] array = str.split(" ");
		if (pattern.length() != array.length) {
			return false;
		}
		Map<Character, Integer> a = new HashMap<>();
		Map<String, Integer> b = new HashMap<>();

		List<Integer> list01 = new ArrayList<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (a.containsKey(c)) {
				list01.add(a.get(c));
			} else {
				a.put(c, i);
				list01.add(i);
			}
		}

		for (int i = 0; i < array.length; i++) {
			int j = i;
			if (b.containsKey(array[i])) {
				j = b.get(array[i]);
			} else {
				b.put(array[i], i);
			}
			if(j!=list01.get(i)){
				return false;
			}
		}
		return true;
	}

}
