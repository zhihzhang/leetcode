package com.lee.againt;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
	// "+"]
	// Output: 22
	// Explanation:
	// ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
	// = ((10 * (6 / (12 * -11))) + 17) + 5
	// = ((10 * (6 / -132)) + 17) + 5
	// = ((10 * 0) + 17) + 5
	// = (0 + 17) + 5
	// = 17 + 5
	// = 22

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+")) {
				String a = stack.pop();
				String b = stack.pop();
				int t = Integer.valueOf(a) + Integer.valueOf(b);
				stack.push(t + "");
			} else if (s.equals("-")) {
				String a = stack.pop();
				String b = stack.pop();
				int t = Integer.valueOf(a) - Integer.valueOf(b);
				stack.push(t + "");
			} else if (s.equals("*")) {
				String a = stack.pop();
				String b = stack.pop();
				int t = Integer.valueOf(a) * Integer.valueOf(b);
				stack.push(t + "");
			} else if (s.equals("/")) {
				String a = stack.pop();
				String b = stack.pop();
				int t = Integer.valueOf(a) / Integer.valueOf(b);
				stack.push(t + "");
			} else {
				stack.push(s);
			}
		}
		int n = Integer.valueOf(stack.pop());
		return n;
	}

}
