package com.lee.aathird;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class MyStack {

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
		System.out.println(obj.pop());

	}

	Queue<Integer> a = new LinkedList<>();
	Queue<Integer> b = new LinkedList<>();
	int v = 0;
	int count = 0;

	/** Initialize your data structure here. */
	public MyStack() {

	}
	
	private void swap(){
		Queue<Integer> t = a;
		a = b;
		b = t;
	}

	/** Push element x onto stack. */
	public void push(int x) {
		if (count > 0) {
			a.offer(v);
		} 
		v = x;
		count++;
	}

	 /** Removes the element on top of the stack and returns that element. */
	 public int pop() {
		 int r = v;
		 count--;
		 if (count > 0) {
			int size = a.size();
			for (int i = 0; i < size-1; i++) {
				b.offer(a.poll());
			}
			v = a.poll();
			swap();
		 }
		 return r;
	 }
	
	 /** Get the top element. */
	 public int top() {
		 return v;
	 }
	
	 /** Returns whether the stack is empty. */
	 public boolean empty() {
		 return count==0;
	 }

}
