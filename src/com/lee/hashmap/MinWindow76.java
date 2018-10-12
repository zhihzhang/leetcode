package com.lee.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MinWindow76 {
	// https://blog.csdn.net/LaiOffer/article/details/80073103

	public static void main(String[] args) {
		MinWindow76 obj = new MinWindow76();

		String s = "1234567890";
		System.out.println(s.substring(0, 5));

		String r = null;

		r = obj.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(r);

		r = obj.minWindow("A", "B");
		System.out.println(r);

		r = obj.minWindow("bba", "ab");
		System.out.println(r);
	}

	public String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int l = 0;
		int r = 0;
		int min = Integer.MAX_VALUE;
		int count = t.length();

		int left = 0;

		while (r < s.length()) {
			if (count > 0) {
				char c = s.charAt(r);
				if (map.containsKey(c)) {
					if (map.get(c) > 0) {
						count--;
					}
					map.put(c, map.get(c) - 1);
				}
			}
			while (count == 0) {
				if (min > r - l + 1) {
					min = r - l + 1;
					left = l;
				}
				char c = s.charAt(l);
				if (map.containsKey(c)) {
					if (map.get(c) >= 0) {
						count++;
					}
					map.put(c, map.get(c) + 1);
				}
				l++;
			}
			r++;
		}

		if (min == Integer.MAX_VALUE) {
			return "";
		}

		return s.substring(left, left + min);

	}

	// public String minWindowTTT(String s, String t) {
	// if(s == null || s.length() < t.length() || s.length() == 0){
	// return "";
	// }
	// HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	// for(char c : t.toCharArray()){
	// if(map.containsKey(c)){
	// map.put(c,map.get(c)+1);
	// }else{
	// map.put(c,1);
	// }
	// }
	// int left = 0;
	// int minLeft = 0;
	// int minLen = s.length()+1;
	// int count = 0;
	// for(int right = 0; right < s.length(); right++){
	// if(map.containsKey(s.charAt(right))){
	// map.put(s.charAt(right),map.get(s.charAt(right))-1);
	// if(map.get(s.charAt(right)) >= 0){
	// count ++;
	// }
	// while(count == t.length()){
	// if(right-left+1 < minLen){
	// minLeft = left;
	// minLen = right-left+1;
	// }
	// if(map.containsKey(s.charAt(left))){
	// map.put(s.charAt(left),map.get(s.charAt(left))+1);
	// if(map.get(s.charAt(left)) > 0){
	// count --;
	// }
	// }
	// left ++ ;
	// }
	// }
	// }
	// if(minLen>s.length())
	// {
	// return "";
	// }
	//
	// return s.substring(minLeft,minLeft+minLen);
	// }

	public String minWindowOrigin(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int l = 0;
		int r = -1;
		int min = Integer.MAX_VALUE;
		int count = t.length();

		int left = 0;

		while (true) {
			if (count > 0) {
				r++;
				if (r == s.length()) {
					break;
				}
				char c = s.charAt(r);
				if (map.containsKey(c)) {
					if (map.get(c) > 0) {
						count--;
					}
					map.put(c, map.get(c) - 1);
					if (count == 0) {
						if (min > r - l + 1) {
							min = r - l + 1;
							left = l;
						}
					}
				}
			} else {
				char c = s.charAt(l);
				l++;
				if (map.containsKey(c)) {
					if (map.get(c) >= 0) {
						count++;
					} else {
						if (min > r - l + 1) {
							min = r - l + 1;
							left = l;
						}
					}
					map.put(c, map.get(c) + 1);

				} else {

					if (min > r - l + 1) {
						min = r - l + 1;
						left = l;
					}
				}

			}
		}
		if (min == Integer.MAX_VALUE) {
			return "";
		}

		return s.substring(left, left + min);

	}

}
