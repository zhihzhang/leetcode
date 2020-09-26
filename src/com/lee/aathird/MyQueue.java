package com.lee.aathird;

import java.util.Stack;

public class MyQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Stack<Integer> a = new Stack<>();
	Stack<Integer> b = new Stack<>();

	/** Initialize your data structure here. */
	public MyQueue() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		a.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (b.isEmpty()) {
			while (!a.isEmpty()) {
				b.add(a.pop());
			}
		}
		return b.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (b.isEmpty()) {
			while (!a.isEmpty()) {
				b.add(a.pop());
			}
		}
		return b.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (a.isEmpty() && b.isEmpty()) {
			return true;
		}
		return false;
	}

}
