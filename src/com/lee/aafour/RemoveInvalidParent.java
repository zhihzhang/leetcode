package com.lee.aafour;

import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	Input: "()())()"
//	Output: ["()()()", "(())()"]
//	Input: "(a)())()"
//	Output: ["(a)()()", "(a())()"]
//	Input: ")("
//	Output: [""]
	public List<String> removeInvalidParentheses(String s) {
		LinkedList<Character> queue = new LinkedList<>();
		int left = 0;
		int right = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				queue.offer(c);
				left++;
			} else if (c == ')') {
				if (right >= left) {
					continue;
				} else {
					right++;
					queue.offer(c);
				}
			} else {
				queue.offer(c);
			}
		}
		
		int t = left - right;
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			char c = queue.pollLast();
			if(c=='(' && t > 0){
				t--;
				continue;
			}
			sb.append(c);
		}
//		return sb.reverse().toString();
		return null;
	}

}
