package com.lee.againt;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ValidAnagram {

	public static void main(String[] args) {
		ValidAnagram obj = new ValidAnagram();
		System.out.println(obj.isAnagram("anagram","nagaram"));
		System.out.println(obj.isAnagram("rat","car"));
	}

	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> a = new TreeMap<>();
		Map<Character, Integer> b = new TreeMap<>();

		for (char c : s.toCharArray()) {
			a.put(c, a.getOrDefault(c, 0) + 1);
		}

		for (char c : t.toCharArray()) {
			b.put(c, b.getOrDefault(c, 0) + 1);
		}
		
		return a.toString().equals(b.toString());

	}

}
