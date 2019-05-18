package com.lee.again;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring obj = new LongestSubstring();
		System.out.println(obj.lengthOfLongestSubstringTwoDistinct("bacc"));

	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		int i = 0;
		while (i < s.length()) {
			int a = i;
			int j = i;
			while (j < s.length()) {
				set.add(s.charAt(j));
				if (set.size() == 1) {
					a = j;
				}
				if (set.size() <= 2) {
					max = Math.max(max, j - i + 1);
				} else {
					set.clear();
					break;
				}
				j++;
			}
			i = a + 1;
		}
		return max;

	}

}
