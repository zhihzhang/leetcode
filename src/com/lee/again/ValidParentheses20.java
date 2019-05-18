package com.lee.again;

import java.util.Stack;

public class ValidParentheses20 {

	public static void main(String[] args) {
		ValidParentheses20 obj = new ValidParentheses20();
		System.out.println(obj.isValid("]"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					continue;
				}
				return false;
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
					continue;
				}
				return false;
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
					continue;
				}
				return false;
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
	}

}
