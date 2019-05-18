package com.lee.again;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString394 {

	public static void main(String[] args) {
		DecodeString394 obj = new DecodeString394();

//		System.out.println(obj.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
		System.out.println(obj.decodeString("sd2[f2[e]g]i"));
		// <2,yy,pq,4,jkjk,e,f>
		// 2,yy,pq,4,jkjkefjkjkefjkjkefjkjkef
		// ef
		
	}
	
	public String decodeString(String s) {
		int num = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		Stack<Object> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				if (temp.length() > 0) {
					if(stack.empty()){
						sb.append(temp);
					}else{
						stack.push(temp);
					}
					temp = new StringBuilder();
				}
				num = num * 10 + (c - '0');
				continue;
			}
			if (c == '[') {
				if (num != 0) {
					stack.push(num);
				} else {
					stack.push(1);
				}
//				stack.push(" ");
				num = 0;
				continue;
			}
			if(c == ']'){
				Stack<Object> ts = new Stack<>();
				while(!stack.isEmpty() && !(stack.peek() instanceof Integer)){
					ts.push(stack.pop());
				}
				StringBuilder asb = new StringBuilder();
				while(!ts.isEmpty()){
					asb.append(ts.pop());
				}
				asb.append(temp);
				
				int n = (int)stack.pop();
				StringBuilder t = new StringBuilder();
				for(int i=0;i<n;i++){
					t.append(asb);
				}
				if(stack.isEmpty()){
					sb.append(t);
				}else{
					stack.push(t);
				}
				temp = new StringBuilder();
				continue;
			}
			temp.append(c);

		}
		sb.append(temp);
		
		return sb.toString();
	}

	

}
