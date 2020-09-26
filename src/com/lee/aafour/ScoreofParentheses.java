package com.lee.aafour;

import java.util.Stack;

public class ScoreofParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Example 1:
	//
	// Input: "()"
	// Output: 1
	// Example 2:
	//
	// Input: "(())"
	// Output: 2
	// Example 3:
	//
	// Input: "()()"
	// Output: 2
	// Example 4:
	//
	// Input: "(()(()))"
	// Output: 6
	public int scoreOfParentheses(String S) {
		Stack<Integer> stack = new Stack<>();
		int n = 0;
		for (char c : S.toCharArray()) {
			if (c == ')') {
				;
			} else if (c == '(') {
				stack.push(-1);
				n = n*2;
			}
		}
		return 0;
	}

}
