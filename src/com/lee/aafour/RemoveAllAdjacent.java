package com.lee.aafour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveAllAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: s = "abcd", k = 2
	// Output: "abcd"
	// Input: s = "deeedbbcccbdaa", k = 3
	// Output: "aa"
	// Input: s = "pbbcggttciiippooaais", k = 2
	// Output: "ps"
	public String removeDuplicates(String s, int k) {
		s = s+"0";
		LinkedList<Character> queue = new LinkedList<>();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (!queue.isEmpty() && c != queue.peekLast()) {
				boolean isRemoveDupolidated = false;
				char x = queue.peekLast();
				List<Character> list = new ArrayList<>();
				while (!queue.isEmpty() && queue.peekLast() == x) {
					list.add(queue.pollLast());
					if (list.size() == k) {
						list.clear();
						isRemoveDupolidated = true;
					}
				}
				for (char y : list) {
					queue.offer(y);
				}
				if (!isRemoveDupolidated) {
					queue.offer(c);
					i++;
				}
			} else {
				queue.offer(c);
				i++;
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (Character c : queue) {
			if(c=='0'){
				continue;
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
