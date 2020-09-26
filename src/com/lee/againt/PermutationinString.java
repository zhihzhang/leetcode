package com.lee.againt;

import java.util.HashMap;
import java.util.Map;

public class PermutationinString {

	public static void main(String[] args) {
		PermutationinString obj = new PermutationinString();
		System.out.println(obj.checkInclusion("ab", "eidbaooo"));
		System.out.println(obj.checkInclusion("ab", "eidboaoo"));
		System.out.println(obj.checkInclusion("hello", "ooolleoooleh"));
	}
	
//	public boolean checkInclusion(String s1, String s2) {
//		int[] count = new int[128];
//		for (int i = 0; i < s1.length(); i++){
//			count[s1.charAt(i)]--;
//		}
//		for (int l = 0, r = 0; r < s2.length(); r++) {
//			if (++count[s2.charAt(r)] > 0){  
//				while (--count[s2.charAt(l++)] != 0) {
//					/* do nothing */}
//			}
//			else if ((r - l + 1) == s1.length()){
//				return true;
//			}
//		}
//		return s1.length() == 0;
//	}

	public boolean checkInclusion(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		int l = 0;
		int r = 0;
		while (r < s2.length()) {
			while (r < s2.length()) {
				if (map.containsKey(s2.charAt(r))) {
					int num = map.get(s2.charAt(r));
					num--;
					map.put(s2.charAt(r), num);
					if (num == 0) {
						counter--;
					}
				}
				if (counter == 0) {
					if (r - l + 1 == s1.length()) {
						return true;
					}
					break;
				}
				r++;
			}
			while (l <= r) {
				if (map.containsKey(s2.charAt(l))) {
					int num = map.get(s2.charAt(l));
					num++;
					map.put(s2.charAt(l), num);
					if (num == 1) {
						counter++;
					}
				}
				l++;
				if (counter == 0) {
					if (r - l + 1 == s1.length()) {
						return true;
					}
				} else if (counter > 0) {
					break;
				}
			}
			r++;
		}
		return false;
	}

}
