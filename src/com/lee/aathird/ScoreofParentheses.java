package com.lee.aathird;

import java.util.Stack;

public class ScoreofParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: "()"
	// Output: 1
	//
	// Input: "(())"
	// Output: 2
	//
	// Input: "()()"
	// Output: 2
	//
	// Input: "(()(()))"
	// Output: 6

	public int scoreOfParentheses(String S) {
		Stack<String> stack = new Stack();
		for (char c : S.toCharArray()) {
			if (c == '(') {
				stack.push(c + "");
			} else {
				String t = stack.pop();
				if (t.equals("(")) {
					stack.push(1 + "");
				} else {
					int sum = 0;
					while (!t.equals("(")) {
						sum += Integer.valueOf(t);
						t = stack.pop();
					}
					stack.push(sum*2 + "");
				}
			}
		}
		int r = 0;
		while (!stack.empty()) {
			r += Integer.valueOf(stack.pop());
		}
		return r;

	}

}
