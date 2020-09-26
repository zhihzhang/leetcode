package com.lee.aafour;

import java.util.LinkedList;

public class MinimumRemoveMakeValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// "lee(t(c)o)de)"
	// "a)b(c)d"
	// "))(("
	// "(a(b(c)d)"
	public String minRemoveToMakeValid(String s) {
		LinkedList<Character> queue = new LinkedList<>();
		int left = 0;
		int right = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				left++;
				queue.offer(c);
			} else if (c == ')') {
				if (right >= left) {
					continue;
				}
                right++;
                queue.offer(c);
			} else {
				queue.offer(c);
			}
		}
		int t = left - right;
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			char c = queue.pollLast();
			if (t > 0 && c == '(') {
                t--;
				continue;
			}
			sb.append(c);
		}
		return sb.reverse().toString();
	}

}
