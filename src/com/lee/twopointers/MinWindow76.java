package com.lee.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindow76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
		if (s == null || t == null) {
			return "";
		}
		// total number of character in p to be contained in s
		int countToBeContained = t.length();
		int minLen = Integer.MAX_VALUE;
		int startIndex = -1;
		// calculate the number of each character to be contained in S
		int[] dict = new int[128];
		for (char c : t.toCharArray()) {
			dict[c]++;
		}

		int fast = 0, slow = 0;
		while (fast < s.length()) {
			// if need to be contained, include it and minus the counter
			if (dict[s.charAt(fast)]-- > 0) {
				countToBeContained--;
			}
			fast++;

			// all included, move the slow pointer to minimize the window
			while (countToBeContained == 0) {
				// current window contains same number of the current character
				// as in t, cannot move forward anymore
				if (dict[s.charAt(slow)]++ == 0){
					countToBeContained++;
				}
				slow++;

				// update minLen
				if (fast - slow + 1 < minLen) {
					startIndex = slow - 1;
					minLen = fast - slow + 1;
				}
			}
		}
		return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
	}

	// public String minWindow(String s, String t) {
	// char[] array = s.toCharArray();
	// Map<Character, List<Integer>> indexMap = new HashMap<Character,
	// List<Integer>>();
	// int index = 0;
	// for (char c : array) {
	// List<Integer> list = indexMap.get(c);
	// if (list == null) {
	// list = new ArrayList<Integer>();
	// indexMap.put(c, list);
	// }
	// list.add(index);
	// index++;
	// }
	//
	// List<Integer> resultList = new ArrayList<Integer>();
	// array = t.toCharArray();
	// for (char c : array) {
	// List<Integer> list = indexMap.get(c);
	// if (list == null) {
	// return "";
	// }
	// }
	// Collections.sort(resultList);
	// }

}
