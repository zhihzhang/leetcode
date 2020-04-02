package com.lee.again;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
//		SimplifyPath obj = new SimplifyPath();
//		String[] array = "/Home/".split("/");
//		System.out.println(Arrays.toString(array));
//		
//		System.out.println(obj.simplifyPath("/home/"));
		
		LinkedList<String> stack = new LinkedList<>();
//		stack.push("1");
//		stack.push("2");
//		stack.push("3");
		
		stack.offer("1");
		stack.offer("2");
		stack.offer("3");
		
		stack.pollLast();
		
		
		System.out.println(stack.toString());
	}

	// Input: "/a//b////c/d//././/.."
	// Output: "/a/b/c"

	public String simplifyPath(String path) {
		LinkedList<String> stack = new LinkedList<>();
		String[] array = path.split("/");
		for (String s : array) {
			if (s.equals("..")) {
				if (stack.isEmpty()) {
					stack.pop();
				}
			} else if (s.length() > 0 && !s.equals(".")) {
				stack.push(s);
			}
		}
		if(stack.isEmpty()){
			return "/";
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append("/").append(stack.pollFirst());
		}
		return sb.toString();
	}

}
