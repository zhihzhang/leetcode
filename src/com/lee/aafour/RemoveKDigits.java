package com.lee.aafour;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
//		System.out.println(obj.removeKdigits("1432219", 3));
		System.out.println(obj.removeKdigits("10200", 1));
	}

	public String removeKdigits(String num, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (char c : num.toCharArray()) {
			int v = c - '0';
			if (k == 0) {
				list.push(v);
				continue;
			}
			if (list.isEmpty()) {
				if (v != 0) {
					list.push(v);
				}
				continue;
			}
			while (!list.isEmpty() && list.peek() > v && k > 0) {
				list.pop();
				k--;
			}
			list.push(v);
		}
		
		while(!list.isEmpty() && k>0){
			list.removeLast();
			k--;
		}

		while (!list.isEmpty() && list.peekLast() == 0) {
			list.removeLast();
		}
		if(list.isEmpty()){
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while(!list.isEmpty()){
			sb.append(list.pop());
		}
		return sb.reverse().toString();
	}

}
