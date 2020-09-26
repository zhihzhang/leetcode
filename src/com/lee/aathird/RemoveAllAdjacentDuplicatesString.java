package com.lee.aathird;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllAdjacentDuplicatesString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	Input: "abbaca"
//		Output: "ca"
	public String removeDuplicates(String S) {
		List<Character> list = new ArrayList<>();
		for (char c : S.toCharArray()) {
			list.add(c);
		}
		int i = 0;
		while (i < list.size()) {
			char c = list.get(i);
			if (i > 0 && list.get(i - 1) == c) {
				list.remove(i - 1);
				list.remove(i - 1);
				i--;
			} else {
				i++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c:list){
			sb.append(c);
		}
		return sb.toString();
	}

}
