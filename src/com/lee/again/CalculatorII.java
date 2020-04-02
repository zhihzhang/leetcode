package com.lee.again;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class CalculatorII {

	public static void main(String[] args) {
		CalculatorII obj = new CalculatorII();
		System.out.println(obj.calculate("140- 50*2 - 25/5*2 + 6"));
	}

	// 3 + 5*2 + 3/2 - 6
	public int calculate(String s) {
		char[] array = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (char c : array) {
			if (c != ' ') {
				sb.append(c);
			}
		}
		array = sb.toString().toCharArray();
		System.out.println(Arrays.toString(array));
		LinkedList<Object> stack = new LinkedList();
		int i = 0;
		while (i < array.length) {
			char c = array[i];
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				stack.addLast(c);
				i++;
			} else {
				int d = c - '0';
				i++;
				while(i<array.length && array[i]<='9' && array[i] >='0'){
					d = d*10 + (array[i]-'0');
					i++;
				}
				if(stack.isEmpty()){
					stack.addLast(d);
				} else if ((Character) stack.peekLast() == '*') {
					stack.pollLast();
					int p = (int) stack.pollLast();
					stack.addLast(p * d);
				} else if ((Character) stack.peekLast() == '/') {
					stack.pollLast();
					int p = (int) stack.pollLast();
					stack.addLast(p / d);
				} else {
					stack.addLast(d);
				}
			}
			System.out.println(stack.toString());
		}
		
		System.out.println("...gogogo");
		int d = 0;
		while(!stack.isEmpty() || stack.size()==1){
			if (stack.peekFirst() instanceof Character && (Character) stack.peekFirst() == '+') {
				stack.pollFirst();
				int p = (int) stack.pollFirst();
				stack.addFirst(p+d);
			} else if(stack.peekFirst() instanceof Character && (Character) stack.peekFirst() == '-'){
				stack.pollFirst();
				int p = (int) stack.pollFirst();
				stack.addFirst(d-p);
			} else {
				d = (int)stack.pollFirst();
			}
			System.out.println(stack.toString());
		}
		
		return d;
	}

}
