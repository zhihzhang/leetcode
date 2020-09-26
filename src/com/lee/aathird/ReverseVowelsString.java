package com.lee.aathird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		char[] a = s.toCharArray();
		List<Integer> nums = new ArrayList<>();
		List<Character> chars = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				chars.add(a[i]);
				nums.add(i);
			}
		}
		Collections.reverse(chars);
		for (int i = 0; i < chars.size(); i++) {
			a[nums.get(i)] = chars.get(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		return sb.toString();
	}

}
