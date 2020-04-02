package com.lee.again;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		String[] tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		int t = obj.evalRPN(tokens);
		System.out.println(t);
//		System.out.println(6/(-132));
	}

	// Input: ["4", "13", "5", "/", "+"]
	// Output: 6
	// Explanation: (4 + (13 / 5)) = 6

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (String s : tokens) {
			if (s.equals("+")) {
				int b = Integer.valueOf(stack.pop());
				int c = Integer.valueOf(stack.pop());
				stack.push((b + c) + "");
			} else if (s.equals("-")) {
				int b = Integer.valueOf(stack.pop());
				int c = Integer.valueOf(stack.pop());
				stack.push((c - b) + "");
			} else if (s.equals("*")) {
				int b = Integer.valueOf(stack.pop());
				int c = Integer.valueOf(stack.pop());
				stack.push((b * c) + "");
			} else if(s.equals("/")){
				int b = Integer.valueOf(stack.pop());
				int c = Integer.valueOf(stack.pop());
				stack.push((int) (c/b) + "");
			} else {
				stack.push(s);
			}
		}
		return Integer.valueOf(stack.pop());
	}

}
